import java.util.*;

public class IteratorTest {
    public static void main(String [] ars){
        test();
    }
    public static void test(){
        var tmp = new ArrayList<String>(Arrays.asList("I", "love", "Meow", "!"));
        /* Traverse Iterable Methods */
        /* 1. 原始方法 : Iterator */
        forEachPrint(tmp);

        /* 2. Enhanced for loop */
        for (String string : tmp) {
            System.out.println(string);
        }

        /* 3. use forEach method of iterable and implement "accept<T>" Method with lambda function */
        tmp.forEach(name -> System.out.println(name));

        /* 4. use forEach method of iterable with "Method Reference" */
        tmp.forEach(System.out::println);
    }

    public static void forEachPrint(Iterable<String> iter){
        for (var iterator = iter.iterator(); iterator.hasNext();){ // 建立 iterator, 由 has next 確認有下一個元素
            System.out.println(iterator.next()); // 確認後便印出
        }
    }
}
