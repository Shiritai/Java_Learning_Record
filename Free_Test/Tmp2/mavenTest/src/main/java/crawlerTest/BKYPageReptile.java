package crawlerTest;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName BKYPageReptile
 * @Description TODO(爬取部落格園文章)
 * @Author 我恰芙蓉王
 * @Date 2020年08月11日 9:38
 * @Version 2.0.0
 **/

public class BKYPageReptile {

    //請求地址
    private static final String URL = "https://www.cnblogs.com";

    //儲存路徑
    private static final String TARGET_PATH = "F://" + "部落格園";

    //行匹配正則
    private static final Pattern LINE_PATTERN = Pattern.compile("<a class=\"post-item-title\" href=\"https://www.cnblogs.com/.*?\\.html\" target=\"_blank\">.*?</a>");

    //url正則
    private static final Pattern URL_PATTERN = Pattern.compile("https://www.cnblogs.com/.*?\\.html");

    //標題/檔名正則
    private static final Pattern TITLE_PATTERN = Pattern.compile(">.*?</a>");

    //標題快取
    private static final List<String> TITLE_LIST = new CopyOnWriteArrayList<>();

    //當前頁數
    private static int PAGE = 1;

    //最大拉取頁數
    private static final int MAX_PAGE = 200;

    //一共拉取部落格篇數
    private static int ALL_COUNT = 0;

    //時間格式
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        //建立根目錄
        File rootDir = new File(TARGET_PATH);
        if (!rootDir.exists()) {
            rootDir.mkdir();
        }

        //建立日誌資料夾
        String logPath = TARGET_PATH + "//拉取日誌";
        File logDir = new File(logPath);
        if (!logDir.exists()) {
            logDir.mkdir();
        }

        //建立日誌檔案
        File logFile = new File(logPath + "//log.txt");
        if (!logFile.exists()) {
            try {
                logFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //迴圈拉取
        while (PAGE <= MAX_PAGE) {
            //日誌內容
            String logContent = "正在拉取第" + PAGE + "頁\n";
            System.err.println("\n" + logContent);
            String param = "PageIndex=" + PAGE;

            try {
                //獲取指定頁頁返回內容
                String response = sendPost(URL, param);

                Matcher matcher = LINE_PATTERN.matcher(response);

                //需要寫入的檔案集合
                ArrayList<FileTemplate> urlList = new ArrayList<>(20);

                /**
                 * 解析返回內容封裝成FileTemplate
                 */
                while (matcher.find()) {
                    //匹配行
                    String matchLine = matcher.group();

                    Matcher matcher1 = TITLE_PATTERN.matcher(matchLine);
                    String title = null;
                    while (matcher1.find()) {
                        //匹配的標題    >標題</a>
                        title = matcher1.group();
                    }
                    //擷取拿到真實標題
                    title = title.substring(1, title.length() - 4);
                    //特殊字元處理
                    title = title.replace("<", "《")
                            .replace(">", "》")
                            .replace("\\", "-")
                            .replace("/", "-")
                            .replace(":", "：")
                            .replace("*", "")
                            .replace("?", "？")
                            .replace("|", "")
                            + ".html";
                    System.err.println("title = " + title);

                    //如果已經拉取了此標題的html檔案   則跳過此篇
                    if (TITLE_LIST.contains(title)) {
                        continue;
                    }

                    Matcher matcher2 = URL_PATTERN.matcher(matchLine);
                    String url = null;
                    while (matcher2.find()) {
                        //匹配部落格的請求url
                        url = matcher2.group();
                    }
                    //封裝成檔案模板物件
                    urlList.add(new FileTemplate(url, title, false));
                }


                /**
                 * 寫入磁碟
                 */
                urlList.parallelStream().forEach(v -> {
                    FileOutputStream fos = null;
                    PrintWriter pw = null;
                    try {
                        String result = sendGet(v.getGetUrl(), "");
                        File file = new File(TARGET_PATH + File.separator + v.getTitle());
                        file.createNewFile();

                        fos = new FileOutputStream(file);
                        pw = new PrintWriter(fos);
                        pw.write(result.toCharArray());
                        pw.flush();
                        v.setFlag(true);

                        TITLE_LIST.add(v.getTitle());
                    } catch (Exception e) {
                        System.out.println(v.toString());
                        e.printStackTrace();
                    } finally {
                        try {
                            if (fos != null) {
                                fos.close();
                            }
                            if (pw != null) {
                                pw.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }
                });

                /**
                 * 記錄日誌
                 */
                //本次寫入成功部落格數
                long count = urlList.stream().filter(v -> v.getFlag()).count();

                String date = SDF.format(new Date());

                //累加次數
                ALL_COUNT += count;

                logContent += "本次拉取完成,共  " + count + "  篇新部落格\r\n";
                logContent += "一共拉取了  " + ALL_COUNT + "  篇\r\n";
                logContent += "時間 : " + date + "\n\n";
                BufferedWriter out = null;
                try {
                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFile, true)));
                    out.write(logContent + "\r\n");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                PAGE++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 檔案模板類
     */
    private static class FileTemplate {
        /**
         * 請求地址
         */
        private String getUrl;

        /**
         * 標題
         */
        private String title;

        /**
         * 已經爬取標識
         */
        private boolean flag;

        public FileTemplate(String getUrl, String title, boolean flag) {
            this.getUrl = getUrl;
            this.title = title;
            this.flag = flag;
        }

        public String getGetUrl() {
            return getUrl;
        }

        public void setGetUrl(String getUrl) {
            this.getUrl = getUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder("FileTemplate{");
            sb.append("getUrl='").append(getUrl).append('\'');
            sb.append(", title='").append(title).append('\'');
            sb.append('}');
            return sb.toString();
        }

        public boolean getFlag() {
            return flag;
        }

        public void setFlag(boolean flag) {
            this.flag = flag;
        }
    }

    /**
     * 功能描述: 向指定URL傳送GET請求
     *
     * @param url   傳送請求的URL
     * @param param 請求引數，請求引數應該是 name1=value1&name2=value2 的形式
     * @建立人: 我恰芙蓉王
     * @建立時間: 2020年08月11日 16:42:17
     * @return: java.lang.String  響應結果
     **/
    public static String sendGet(String url, String param) {
        StringBuilder sb = new StringBuilder();
        BufferedReader in = null;
        try {
            String urlNameString = url + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 開啟和URL之間的連線
            URLConnection connection = realUrl.openConnection();
            // 設定通用的請求屬性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立實際的連線
            connection.connect();
            // 獲取所有響應頭欄位
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定義 BufferedReader輸入流來讀取URL的響應
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println("傳送GET請求出現異常！" + e);
            e.printStackTrace();
        }
        // 使用finally塊來關閉輸入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 功能描述: 向指定URL傳送POST請求
     *
     * @param url   傳送請求的URL
     * @param param 請求引數，請求引數應該是 name1=value1&name2=value2 的形式
     * @建立人: 我恰芙蓉王
     * @建立時間: 2020年08月11日 16:42:17
     * @return: java.lang.String  響應結果
     **/
    public static String sendPost(String url, String param) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder sb = new StringBuilder();
        try {
            URL realUrl = new URL(url);
            // 開啟和URL之間的連線
            URLConnection conn = realUrl.openConnection();
            // 設定通用的請求屬性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 傳送POST請求必須設定如下兩行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            // 獲取URLConnection物件對應的輸出流
            out = new PrintWriter(conn.getOutputStream());
            // 傳送請求引數
            out.print(param);
            // flush輸出流的緩衝
            out.flush();
            // 定義BufferedReader輸入流來讀取URL的響應
            in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                sb.append(line);
            }
        } catch (Exception e) {
            System.out.println("傳送 POST 請求出現異常！" + e);
            e.printStackTrace();
        }
        //使用finally塊來關閉輸出流、輸入流
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return sb.toString();
    }
}