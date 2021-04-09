import java.util.Comparator;

interface Meow {
    public void doMeow();
}

interface LuckyNum {
    Integer assign(Integer i);
}

public class LambdaTest {
    public static void main(String [] args){
        /* 一般使用匿名介面，需覆寫其抽象函數 */
        var meow0 = new Meow() {
            public void doMeow(){
                System.out.println("Meow0 ~");
            }
        };
        /* Lambda 表達式, ([parameter0, parameter1, ...]) -> [function content] */
        Meow meow1 = () -> System.out.println("Meow1 ~");

        /* Type inference of compiler, 編譯器的型態推斷 */
        LuckyNum num0 = (Integer i) -> i * 1000;
        /* 甚至「單一參數」可以省略類型宣告 */
        LuckyNum num1 = (i) -> i * 3141;
        /* 甚至「單一參數」可以不要 () */
        LuckyNum num2 = i -> i * 1618;

        /* String 比較函數實作 */
        Comparator<String> byLength1 = new Comparator<>(){ // JDK 9 省略泛型的實際型態, JDK 10 後可改用 var
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        };
        /* 利用編譯器類別判斷簡寫成 lambda */
        Comparator<String> byLength2 = (s1, s2) -> s1.length() - s2.length();
    }    
}
