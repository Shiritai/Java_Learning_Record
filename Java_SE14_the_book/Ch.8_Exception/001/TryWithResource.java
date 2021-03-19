import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class TryWithResource {
    public static String readFile(Scanner console) throws FileNotFoundException{
        var fileName = new Scanner(in);
        console = new Scanner(new FileInputStream(fileName.nextLine()));
        StringBuilder text = new StringBuilder();

        /* Compiler Sugar OwO */
        try (fileName; Scanner tmp = console){ 
            // 上面 fileName 的部分JDK9 後可通過編譯，若變數為 final 或等效於 final 就可以如上撰寫
            // 本來應該是：Scanner tmp1 = fileName;
            // 多個想用 Compiler Sugar 的變數，以 ";" 區隔
            while (console.hasNext()){
                text.append(console.nextLine()).append("\n");
            }
        }
        return text.toString();
    }
    
    public static void main(String [] args){
        Scanner tmp = null;
        try {
            out.println(readFile(tmp));
        } catch (FileNotFoundException ex){
            out.println("請輸入正確檔名。");
        } finally {
            out.println("__Final_msg__");
        }
    }
}
