import java.util.Properties;
import java.util.*;

public class MapTest {
    public static void main(String[] args){
        // testProperties();
        testMapIterate();
    }

    public static void testProperties(){ // Properties 還有其他進階用法，比如可以讀檔 (load()) ...不過等我用的到再說
        var props = new Properties();
        props.setProperty("name", "Eroiko");
        props.setProperty("score", "3.14");
        System.out.println(props.getProperty("score"));
        System.out.println(props.getProperty("name"));
    }

    public static void testMapIterate(){
        var nameArr = Arrays.asList("Eroiko", "Yotsugi", "Yukino", "Madoka");
        var numArr = Arrays.asList(70, 0, 100, 60);
        var hsMap = new HashMap<String, Integer>();
        var trMap = new TreeMap<String, Integer>(
            (s1, s2) -> -s1.compareTo(s2)
        );
        for (int i = 0; i < 4; ++i){
            hsMap.put(nameArr.get(i), numArr.get(i));
            trMap.put(nameArr.get(i), numArr.get(i));
        }
        /* Traverse Map */
        
        /* 1. Traverse key / value set */
        hsMap.keySet().forEach(MapTest::printEle);
        printEle("\n");
        hsMap.values().forEach(MapTest::printEle);
        printEle("\n");
        trMap.keySet().forEach(MapTest::printEle); // 可見 TreeMap 的排序特性
        printEle("\n");
        trMap.values().forEach(MapTest::printEle);
        printEle("\n");

    }

    public static void printEle(Object obj){
        System.out.printf("%s ", obj);
    }

}
