package crawlerTest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

// import crawlerTest.myPair;

public class CrawlerZeroChan extends Crawler{
    
    /* 測試下載 number 數量的圖需要訪問多少頁面 */
    public int howManyPagesShouldRead(int number){
        int cnt = 0;
        int page = 0;
        while (cnt < number){
            try {
                var doc = Jsoup.connect(this.first_layer_url + "&p=" + Integer.toString(++page))
                    .userAgent(Crawler.UserAgent)
                    .timeout(10000)
                    .get();
                cnt += doc.select("img[title]").size();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return page;
    }


    
    /* 讀取第一頁, 未來支持外部多線程 */
    public ArrayList<myPair<String, String>> downloadPreviewAndFetchFullImageLink(){
        try {
            var doc = Jsoup.connect(this.first_layer_url)
                .userAgent(Crawler.UserAgent)
                .timeout(10000)
                .get();
            System.out.println(doc.title()); // 印出標頭, 確保目標正確

            Elements links = doc.select("img[title]"); // 抓取預覽圖, 預覽圖都有 title
            Elements target = doc.select("a[tabindex=1]");
            
            var size = links.size();
            var data = new ArrayList<myPair<String, String>>(size);

            Iterator<org.jsoup.nodes.Element> it1 = links.iterator(), it2 = target.iterator();
            while (it1.hasNext() && it2.hasNext()){
                data.add(new myPair<String, String>(it1.next().attr("src"), CrawlerZeroChan.url_head + it2.next().attr("href") + "#full"));
            }

            // for (int i = 0; i < size; ++i){
            //     data.add(new myPair<String, String>(links.get(i).attr("src"), CrawlerZeroChan.url_head + target.get(i).attr("href") + "#full"));
            // }

            // var index = i; // 需要多一個變數保存前執行續要處理的 index
            // new Thread(() -> {
                // data.add(new myPair<String, String>(links.get(index).attr("src"), CrawlerZeroChan.url_head + target.get(index).attr("href") + "#full"));
            // }).start();
            
            // data.forEach(d -> System.out.println(d.value)); // just for check

            // data.forEach(d -> this.downloadPicture(d.key, false)); // 順便練練 forEach(lambda)
            for (var d : data){
                new Thread(() -> {
                    this.downloadPicture(d.key, false);
                }).start();
            }
            // data.forEach(d -> this.downloadPicture(d.key, false)); // 順便練練 forEach(lambda)
            return data;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<ArrayList<myPair<String, String>>> readMultiplePagesAndDownloadPreviews(int pages){
        var res = new ArrayList<ArrayList<myPair<String, String>>>(pages);
        for (int i = 1; i <= pages; i += 8){
            for (int j = i; j < i + 8 && j <= pages; ++j){
                int index = j;
                var tmpThread = new Thread(() -> {
                    res.add(downloadPreviewAndFetchFullImageLink(index));
                });
                tmpThread.start();
            }
        }
        return res;
    }

    /* 讀取特定頁面 */
    public ArrayList<myPair<String, String>> downloadPreviewAndFetchFullImageLink(int page){
        try {
            var doc = Jsoup.connect(this.first_layer_url + "&p=" + Integer.toString(page))
                .userAgent(Crawler.UserAgent)
                .timeout(10000)
                .get();
            System.out.println(doc.title()); // 印出標頭, 確保目標正確

            Elements links = doc.select("img[title]"); // 抓取預覽圖, 預覽圖都有 title
            Elements target = doc.select("a[tabindex=1]");

            var size = links.size();
            var data = new ArrayList<myPair<String, String>>(size);
            for (int i = 0; i < size; ++i){
                data.add(new myPair<String, String>(links.get(i).attr("src"), CrawlerZeroChan.url_head + target.get(i).attr("href") + "#full"));
            }
            for (var d : data){
                this.downloadPicture(d.key, false);
            }
            return data;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /* 返回下載張數, 需要再實作ㄅ */
    public int downloadSelectedImagesUsingSTR(ArrayList<String> data){
        return 0;
    }

    /* 返回下載張數, 未來支持內部多線程 */
    public void downloadSelectedImagesUsingPAIR(ArrayList<myPair<String, String>> data){
        for (var str : data){
            new Thread(() -> {
                try {
                    var doc = Jsoup.connect(str.value)
                        .userAgent(Crawler.UserAgent)
                        .timeout(10000)
                        .get();
                    // System.out.println(doc.title()); // just for sure!
                    Element target = doc.select("a[class=preview]").first();
                    if (target != null){
                        this.downloadPicture(target.attr("href"), true);
                    }
                    else {
                        System.out.println("There is a null full image with url : " + str);
                    }
                } catch (Exception e){
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static final String url_head = "https://www.zerochan.net/";
    public static final String [] select_header = {"d=", "s="};
    public static final String [][] select_content = {{"0", "1", "2"}, {"id", "fav", "random"}};
    private int [] select = new int [2];
    
    public CrawlerZeroChan(String folder_path, String [] keywords){
        this.folder_path = folder_path;
        this.query = String.join("+", keywords);
        File out = new File(this.folder_path); // 確認目標地址存在
        File outPrev = new File(this.folder_path + "/previews"); // 確認目標地址存在
        if (!out.exists()){ // 不存在則建立之
            out.mkdirs();
        }
        if (!outPrev.exists()){ // 不存在則建立之
            outPrev.mkdirs();
        }
    }

    /* {0, 1, 2}, {id, fav, random} */
    public void setFirstLayerUrl(int resolution, int sorting){
        this.select[0] = resolution;
        this.select[1] = sorting;
        var tmp = new StringBuilder();
        tmp.append(CrawlerZeroChan.url_head).append(this.query).append('?')
            .append(CrawlerZeroChan.select_header[0]).append(CrawlerZeroChan.select_content[0][this.select[0]])
            .append('&').append(CrawlerZeroChan.select_header[1]).append(CrawlerZeroChan.select_content[1][this.select[1]]);
        this.first_layer_url = tmp.toString();
    }

    public void setQuery(String [] keywords){
        this.query = String.join("+", keywords);
    }
    
    public String getFolderPath(){ return this.folder_path; }
    public String getQuery(){ return this.query; }
    public String getFirstLayerUrl(){ return this.first_layer_url; }
}
