package eroiko.javalearning;

import crawlerTest.CrawlerZeroChan;
import static java.lang.System.*;

import java.io.*;
import java.util.Scanner;
// import java.util.TreeMap;

// import jdk.dynalink.linker.GuardingTypeConverterFactory;

// import java.io.IOException;
// import javafx.application.Application;
// import javafx.fxml.FXMLLoader;
// ru阿太小import javafx.scene.*;
// import javafx.stage.Stage;
/**
 * Hello world!
 *
 */
public class App /* extends Application */{
    public static void main(String[] args) {
        
        var console = new Scanner(in);

        var zch = new CrawlerZeroChan(
            "D:/ShiZu_Code/Java/Java_Learning_Record/Free_Test/Tmp2/mavenTest/target/CrawlerIamges/img1",
            console.nextLine().split(" "));
        zch.setFirstLayerUrl(2, 1);
        System.out.println(zch.getFirstLayerUrl());

        // System.out.println("How many images would you like to download?");
        // out.println(zch.howManyPagesShouldRead(console.nextInt()));
        
        // zch.downloadSelectedImagesUsingPAIR(zch.downloadPreviewAndFetchFullImageLink());
        
        zch.readMultiplePagesAndDownloadPreviews(console.nextInt());

        console.close();
        
        // var config = new CrawlConfig();
        // config.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:87.0) Gecko/20100101 Firefox/87.0");
        // config.setIncludeBinaryContentInCrawling(true);
        
        // File crawlStorage = new File("src/test/resources/crawler4j");
        // config.setCrawlStorageFolder(crawlStorage.getAbsolutePath());

        // int numCrawlers = 12;

        // PageFetcher pageFetcher = new PageFetcher(config);
        // RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        // RobotstxtServer robotstxtServer= new RobotstxtServer(robotstxtConfig, pageFetcher);
        // CrawlController controller = null;
        // try {
        //     controller = new CrawlController(config, pageFetcher, robotstxtServer);
        // } catch (Exception e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // controller.addSeed("https://www.baeldung.com/");

        // CrawlController.WebCrawlerFactory<ImageCrawler> factory = () -> new ImageCrawler(new File(
        //     "D:/ShiZu_Code/Java/Java_Learning_Record/Free_Test/Tmp2/mavenTest/target/CrawlerIamges/img1/tmp"
        // ));

        // controller.start(factory, numCrawlers);


    }
    // @Override
    // public void start(Stage stage){

    // }
}
