package crawler4jTest.sample;

import java.io.*;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.*;
import edu.uci.ics.crawler4j.parser.BinaryParseData;
import edu.uci.ics.crawler4j.url.WebURL;

public class ImageCrawler extends WebCrawler {
    private final static Pattern EXCLUSIONS = Pattern.compile(".*(\\.(css|js|xml|gif|mp3|mp4|zip|gz|pdf))$");
  
    private static final Pattern IMG_PATTERNS = Pattern.compile(".*(\\.(png|jpg|jpeg))$");
  
    private File saveDir;
  
    public ImageCrawler(File saveDir) {
        this.saveDir = saveDir;
    }

    @Override
    public boolean shouldVisit(Page ref, WebURL url){
        String urlString = url.getURL().toLowerCase();
        if (EXCLUSIONS.matcher(urlString).matches()) {
            return false;
        }
        if (IMG_PATTERNS.matcher(urlString).matches() || urlString.startsWith("https://www.zerochan.net/")){
            return true;
        }
        return false;
    }

    @Override
    public void visit(Page page){
        String url = page.getWebURL().getURL();
        if (IMG_PATTERNS.matcher(url).matches() && page.getParseData() instanceof BinaryParseData) {
            var in = page.getContentData();
            try (var out = new FileOutputStream("D:/ShiZu_Code/Java/Java_Learning_Record/Free_Test/Tmp2/mavenTest/target/CrawlerIamges/img1")){ // try auto close
                var length = in.length;
                if (length != -1){
                    out.write(in, 0, length);
                }
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

}
