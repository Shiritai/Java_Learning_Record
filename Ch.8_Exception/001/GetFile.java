import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class GetFile {
    public static void main(String[] args) throws FileNotFoundException { // 在宣告方法時丟出例外
        var text = new StringBuilder();
        Scanner console = null;
        try {
            console = new Scanner(new FileInputStream(args[0]));
            while (console.hasNext()){
                text.append(console.nextLine()).append("\n");
            }
        } catch (FileNotFoundException ex) {

            out.println("找不到指定檔案，請修正。");
            ex.printStackTrace();
            throw ex; // 執行時丟出例外，系統接到此後會再丟一份 ex.printStackTrace()

        } catch (ArrayIndexOutOfBoundsException ex){

            out.println("請在引數附上欲閱讀檔案之檔名");
            ex.printStackTrace();
            Throwable msg = ex.fillInStackTrace(); // 重新填裝例外 Stack，起點為重拋例外處，即這行
            throw (ArrayIndexOutOfBoundsException) msg;

        } finally { // 遇到例外時，程式中斷，若有未關閉的資源以及想做個收尾的程式碼，須藉由 finally 來做完成
            /* *
             * finally 無論是否有例外都會執行
             * 即便 try, catch 裡有 return, 也會先執行 finally 再返回
             * */
            if (console != null)
                console.close();
            out.println("Executed finally!");
            
        }
        out.println(text.toString());
    }
    
}