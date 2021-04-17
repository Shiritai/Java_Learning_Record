package crawlerTest;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

public class JsoupTest {
    @Test
    public static void testUrl(String url) throws Exception{
        /* 解析 url */
        Document doc = Jsoup.parse(new URL(url), 10000); // parameter : (URL, 訪問時間限制)
        /* 取並印出 title */
        System.out.println(doc.getElementsByTag("title").first().text());
    }

    @Test
    public static void testParseHtmlString(String filePath, String tagName) throws Exception{
        /* 以工具類讀取文件得到 String */
        var fileString = FileUtils.readFileToString(new File(filePath), "utf8");
        /* Parser String */
        var doc = Jsoup.parse(fileString);
        var targetString = doc.getElementsByTag(tagName).first().text();
        System.out.println((targetString.length() != 0) ? targetString : "<Empty></Empty>");
    }
    
    @Test
    public static void testParseHtmlFile(String filePath, String tagName) throws IOException{
        var doc = Jsoup.parse(new File(filePath), "utf8");
        
        var targetString = doc.getElementsByTag(tagName).first().text();
        System.out.println((targetString.length() != 0) ? targetString : "<Empty></Empty>");
    }

    @Test
    public static void testDom(String filePath, String tagName) throws Exception{
        var doc = Jsoup.parse(new File(filePath), "utf8");

        /* get element by ID */
        // var eleID = doc.getElementById("line100");
        // System.out.println(eleID.text().length() != 0 ? eleID.text() : "<Empty></Empty>");
        // System.out.println(eleID.toString()); // 連帶標籤一起，印出整行

        /* get element by tag */
        // var eleTag = doc.getElementsByTag("span").first().text();
        // System.out.println(eleTag.length() != 0 ? eleTag : "<Empty></Empty>");
        
        /* *
         * get element by Class 
         * 注意，Class 裡的項目，只用其中一個搜尋亦可
         * 如 <li id+"test" class=class_a class_b>Meow</li>
         * 使用 .getElementsByClass("class_a class_b")
         * 或者 .getElementsByClass("class_a")
         * 或者 .getElementsByClass("class_b")
         * 都可以獲得 Meow 訊息!
         */
        // var eleClass = doc.getElementsByClass("attribute-name").first().text();
        // System.out.println(eleClass.length() != 0 ? eleClass : "<Empty></Empty>");
        
        /* get element by Attribute */
        // var eleAttr = doc.getElementsByAttribute("class").first().text();
        // System.out.println(eleAttr.length() != 0 ? eleAttr : "<Empty></Empty>");
        var eleAttrVal = doc.getElementsByAttributeValue("href", "view-source:https://s3.zerochan.net/Jujutsu.Kaisen.240.3293712.jpg").first().text();
        System.out.println(eleAttrVal.length() != 0 ? eleAttrVal : "<Empty></Empty>");   
    }

    @Test
    public static void testDomData() throws Exception {
        
    }
    
    public static void main(String[] args){
        String somePath = "D:/ShiZu_Code/Java/Java_Learning_Record/Free_Test/Tmp2/mavenTest/src/main/resources/html_src/https _www.zerochan.net_.html";
        try {
            // testParseHtmlString(somePath, "a");
            // testParseHtmlFile(somePath, "a");
            testDom(somePath, "a");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
