import static java.lang.System.*;
import java.io.*;
import java.util.*;

public class Average {
    public static void main(String[] args){
        int sum = 0; 
        int cnt = 0; 
        
        // int tmp = in.read(); // try run this and you'll get a error message

        // try {
        //     tmp = in.read(); // read ASCII code
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        var console = new Scanner(in);
        while (true){
            try {
                var tmp = console.nextInt();
                if (tmp == 0){
                    break;
                }
                sum += tmp;
                ++cnt;
            } catch (InputMismatchException ex){
                // ex.printStackTrace(); // 印出堆疊追蹤，實際上預設都會印出這個
                console.next(); // 把那個非整數給讀掉，否則 InputStream 上的「非整數」會一直觸發例外，infinite loop
                out.println("請輸入整數...");
            }
        }
        console.close();
        out.println((float) sum / cnt);
    }
    
}
