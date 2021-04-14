package eroiko.javalearning;

import java.util.TreeMap;

import jdk.dynalink.linker.GuardingTypeConverterFactory;

// import java.io.IOException;
// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// import javafx.scene.*;
// import javafx.stage.Stage;
/**
 * Hello world!
 *
 */
public class App /* extends Application */{
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // try {
        //     crawlerTest.testHttp("https://github.com/Shiritai");
        // } catch (IOException ie){
        //     ie.printStackTrace();
        // }
                
                
        // var paraMap = new TreeMap<String, String>();
        // crawlerTest.crawlerTest.testHttpGetWithParameter("https://github.com/Shiritai", paraMap);
        // https://www.mobile01.com/topicdetail.php?f=18&t=6344693
        // paraMap.put("f", "18");
        // paraMap.put("t", "6344693");
        // crawlerTest.crawlerTest.testHttpPostWithParameter("https://www.mobile01.com/topicdetail.php", paraMap);

        // var wallpaperMap = new TreeMap<String, String>();
        // wallpaperMap.put("q", "id:132");
        // var mainUrl = "https://wallhaven.cc/search";
        // crawlerTest.crawlerTest.testHttpGetWithParameter(mainUrl, wallpaperMap);

        
        // var manyUrls = new String [] {"https://github.com/Shiritai", "https://www.google.com.tw/"};
        // crawlerTest.crawlerTest.testHttpClientPool(manyUrls);

        // String gitHubUrl = "https://github.com/Shiritai";
        // crawlerTest.crawlerTest.testHttpConfig(gitHubUrl);

        // String awsWPP = "https://wallhaven.cc/";
        // String monogatari = "/tag/132";
        // try {
        //     crawlerTest.JsoupTest.testUrl(awsWPP + monogatari);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }

        String somePath = "D:/ShiZu_Code/Java/Java_Learning_Record/Free_Test/Tmp2/mavenTest/src/main/resources/html_src/https _wallhaven.cc_search q=id 132.html";
        try {
            crawlerTest.JsoupTest.testParseHtmlString(somePath, "title");
        } catch (Exception e) {
            e.printStackTrace();
        }


        // String [] justTest = new String [1];
        // try {
        //         crawler4jTest.Controller.main(justTest);
        // } catch (Exception e) {
        //         e.printStackTrace();
        // }
            
    }
    // @Override
    // public void start(Stage stage){

    // }
}
