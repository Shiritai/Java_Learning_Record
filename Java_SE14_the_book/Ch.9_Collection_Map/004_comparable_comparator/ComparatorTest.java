import java.util.*;
import static java.util.Comparator.*;

class tmpClass implements Comparable<tmpClass>{
    private String name;
    private int attack;
    private int defence;
    public tmpClass(String name, int attack, int defence){
        this.attack = attack;
        this.defence = defence;
        this.name = name;
    }
    @Override
    public int compareTo(tmpClass tmp){
        /* 先看 attack 由大到小，再看防禦力由大到小，最後看名字 (字典序) */
        return (this.attack != tmp.attack) ? -(this.attack - tmp.attack) : ((this.defence != tmp.defence) ? -(this.defence - tmp.defence) : ((this.name.compareTo(tmp.name) > 0) ? 1 : -1));
    }
    @Override
    public String toString(){
        return String.format("[%s %d %d]", name, attack, defence);
    }
}

public class ComparatorTest {
    public static void main(String[] args){
        sortTest();
    }
    
    public static void printEle(Object o){
        System.out.printf("%s  ", o);
    }
    
    public static void sortTest(){
        var numbers = Arrays.asList(30, 20, 60, 40, 10, 50);
        Collections.sort(numbers); // 因為 Integer 有 a.compareTo(b), 因此可以直接 sort
        numbers.forEach(ComparatorTest::printEle);
        /* 對於一個類別，定義 compareTo 方法便可以直接 sort */
        var accounts = Arrays.asList(
            new tmpClass("Senjyougahara", 100, 5),
            new tmpClass("Eroiko2", 10, 20),
            new tmpClass("KissShot", 0x7fffffff, 0),
            new tmpClass("Eroiko1", 10, 20),
            new tmpClass("Hanekawa", 10, 10)
        );
        Collections.sort(accounts);
        System.out.println();
        accounts.forEach(ComparatorTest::printEle);
        
        /* *
        * 可以藉由覆寫 compareTo() 來改變 sort 方式 
        * 但你有聽過可以覆寫 Integer 這種事嗎，顯然不行...
        * 遇到這種不能獲不方便拿來實作 Comparable 的情況時
        * 可以藉由 implement "int compare(a, b)" in java.util.Comparator
        * 來實現修改排序的方式
        * */
        System.out.println();
        Collections.sort(numbers, (a, b) -> -a.compareTo(b)); // Collections.sort 另一個重載 : 加上 comparator 的 compare() method
        numbers.forEach(ComparatorTest::printEle);

        /* 也可以使用 List 或 Array 內建的 sort Method, 效果一樣 */

        numbers.sort(Integer::compareTo); // 對 Integer 來說， .sort(Integer::compare) 也有相同效果
        System.out.println();
        numbers.forEach(ComparatorTest::printEle);
        var numbers2 = Arrays.asList(1, 3, 5, 7, 6, 4, 2, 0);

        numbers2.sort(Integer::compare); // 對 Integer 來說， .sort(Integer::compareTo) 也有相同效果
        System.out.println();
        numbers2.forEach(ComparatorTest::printEle);
        
        /* 對於 String */
        System.out.println();
        var names = Arrays.asList("Yukinoshita Yukino", "Yuigahama Yui", "Hikigaya Hachiman", "Ishiki Iroha");
        Collections.sort(names); // String 因為自己就有 compareTo (i.e. implemented Comparable)，可直接使用 sort
        names.forEach(ComparatorTest::printEle);
        
        /* *
         * For TreeSet, 其資料結構 (紅黑樹) 需要可比性才可以運作
         * 因此必須是 Comparable (否則會有 ClassCastException) 
         * 或者 Construct TreeSet 時指定 Comparator 物件
         * */
        
        /* Comparator */
        var names2 = Arrays.asList("Yukinoshita Yukino", null, "Yuigahama Yui", null, "Hikigaya Hachiman", null, "Ishiki Iroha");
        names2.sort(nullsFirst(reverseOrder())); // null 優先 + 反原順序 (字典序)
    }
}
