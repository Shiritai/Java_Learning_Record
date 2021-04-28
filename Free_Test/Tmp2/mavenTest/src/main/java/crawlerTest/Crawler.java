package crawlerTest;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Pattern;

public class Crawler {
    protected final static String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:87.0) Gecko/20100101 Firefox/87.0";
    protected String folder_path;
    protected String query;
    protected String first_layer_url;
    protected static int prevCnt = 1;
    protected static int fullCnt = 1;

    /* 負責讀資料 + 寫檔案 */
    public static void dump(InputStream in, OutputStream out) throws IOException {
        try (var input = new BufferedInputStream(in); 
             var output = new BufferedOutputStream(out)){ // try auto close
            var data = new byte[1024];
            var length = 0;
            while ((length = input.read(data)) != -1){
                output.write(data, 0, length);
            }
        }
    }
    
    public void downloadPicture(String url, boolean isFull){
        if (Pattern.matches(".*?jpe?g|png|gif$", url)){ // 確認是否為圖片檔案
            String suffix = url.substring(url.lastIndexOf('.', url.length()));
            URL src = null;
            try {
                src = new URL(url);
            } catch (MalformedURLException e) {
                System.out.println("The url was malformed!");
                e.printStackTrace();
            }
            URLConnection uri = null;
            try {
                uri = src.openConnection();
            } catch (IOException e) {
                System.out.println("Connection " + url + " failed!");
                e.printStackTrace();
            }
            try {
                InputStream in = uri.getInputStream();
                OutputStream out = new FileOutputStream(new File(
                        (isFull) ? this.folder_path : this.folder_path + "/previews",
                        String.format("wallpaper%d%s", (isFull) ? Crawler.fullCnt++ : Crawler.prevCnt++, suffix))
                    );
                Crawler.dump(in, out);
            } catch (IOException e){    
                System.out.println("IO failed!");
                e.printStackTrace();
            }
        }
    }
    // URL url = null;
    // try {
        //     url = new URL(urlString);
        // } catch (MalformedURLException e) {
    //     System.out.println("The url was malformed!");
    //     e.printStackTrace();
    // }
    // Crawler.dump(url.openStream(), new FileOutputStream(this.folder_path));
        // HttpURLConnection connection = null;
        // //循环下载
        // try {
        //     for (int i = 0; i < downloadList.size(); i++) {
        //         pool = Executors.newFixedThreadPool(24);

        //         ImageModel imageModel = downloadList.get(i);
        //         if (imageModel == null) continue;
        //         final String download_url = imageModel.getImage_url();
        //         final String filename = imageModel.getImage_name();
        //         int page = imageModel.getPage();
        //         int postion = imageModel.getPostion();

        //         Future<HttpURLConnection> future = pool.submit(new Callable<HttpURLConnection>() {
        //             @Override
        //             public HttpURLConnection call() throws Exception {
        //                 URL url;
        //                 url = new URL(download_url);
        //                 HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        //                 //设置超时间为3秒
        //                 connection.setConnectTimeout(3 * 1000);
        //                 //防止屏蔽程序抓取而返回403错误
        //                 connection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        //                 return connection;
        //             }
        //         });
        //         connection = future.get();
        //         if (connection == null) continue;
        //         int responseCode = connection.getResponseCode();
        //         System.out.println("正在下载第" + page + "页第" + postion + "个文件，地址：" + download_url + "响应码：" + connection.getResponseCode());
        //         if (responseCode != 200) continue;
        //         InputStream inputStream = connection.getInputStream();
        //         if (inputStream == null) continue;
        //         writeFile(inputStream, "d:\\ImageCrawler\\" + keyword + "\\", URLDecoder.decode(filename, "UTF-8"));
        //     }
        // } catch (Exception e) {
        //     e.printStackTrace();
        // } finally {
        //     if (null != connection)
        //         connection.disconnect();
        //     if (null != pool)
        //         pool.shutdown();
        //     while (true) {
        //         if (pool.isTerminated()) {//所有子线程结束，执行回调
        //             if (downloadCallBack != null) {
        //                 downloadCallBack.allWorksDone();
        //             }
        //             break;
        //         }
        //     }
        // }
        // // 利用 URL 解析網址
        // URL urlObj = null;
        // try {
        //     urlObj = new URL(url);
        // }
        // catch(MalformedURLException e){
        //     System.out.println("The url was malformed!");
        // }
        // // URL連線
        // URLConnection urlCon = null;
        // try {
        //     // 開啟URL連線
        //     urlCon = urlObj.openConnection(); 
        //     // 將HTML內容解析成UTF-8格式
        //     Document doc = Jsoup.parse(urlCon.getInputStream(), "utf-8", url);
        //     // 提取電影圖片所在的HTML程式碼塊
        //     Elements elems = doc.getElementsByClass("ss-3 clear");
        //     Elements pic_block = elems.first().getElementsByTag("a");
        //     for(int i=0; i<pic_block.size(); ++i) {
        //         // 提取電影圖片的url, name
        //         String picture_url = pic_block.get(i).getElementsByTag("img").attr("src");
        //         // String picture_name = pic_block.get(i).getElementsByClass("bb").text() ".jpg";
        //         // 用download()函式將電影圖片下載到本地
        //         // download(picture_url, dir, picture_name);
        //         // System.out.println("第" (i 1) "張圖片下載完畢！");
        //     }
        // }
        // catch(IOException e){
        //     System.out.println("There was an error connecting to the URL");
        // }
}
