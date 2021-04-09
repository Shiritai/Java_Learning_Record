package a6_109502012_1;
/* 請注意以下之 for 迴圈有依照題目要求，使用到 Array (String []) 的概念 */
import java.util.Scanner;
import static java.lang.System.*;
public class SecondLarge {
    public static void main(String [] args){
        var console = new Scanner(in);
        int tmp = 0x80000000, first = 0x80000000, second = 0x80000000;
        while (true) {
            var tmp__ = console.nextLine().replace("\n", "");
            if (tmp__.equals("STOP"))
                break;
            for (var i : tmp__.split(" ")){ // 此處有用到 Array
                tmp = Integer.valueOf(i);
                if (tmp > second && tmp != first){
                    second = tmp;
                }
                if (second > first){
                    int tmp_ = first;
                    first = second;
                    second = tmp_;
                }
            }
            out.printf("%s\n", second == 0x80000000 ? "Please enter more than two numbers!" : String.valueOf(second));
            first = 0x80000000;
            second = 0x80000000;
        }
        console.close();
    }
}
