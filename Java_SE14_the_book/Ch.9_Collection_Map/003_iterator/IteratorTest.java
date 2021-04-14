import java.util.ArrayList;

public class IteratorTest {
    public static void main(String [] ars){
        test();
    }
    public static void test(){
        var tmp = new ArrayList<String>();
        tmp.add("I");
        tmp.add("love");
        tmp.add("Meow");
        tmp.add("!");
        tmp.forEach(System.out::println);
    }
}
