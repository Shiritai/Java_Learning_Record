import java.util.ArrayList;
import java.util.Random;
import static java.lang.System.*;

public class Main {

    public static void main(String [] args){
        var bstMap = new BSTMap<String, Integer>();
        readBook("pride-and-prejudice", bstMap, "Binary Search Tree Map");
        out.println();
        var AVLMap = new AVLMap<String, Integer>();
        readBook("pride-and-prejudice", AVLMap, "AVL Tree Map");
        out.println();
        var RBMap = new RedBlackMap<String, Integer>();
        readBook("pride-and-prejudice", RBMap, "Red Black Tree Map");
        out.println();
        var ht = new HashTable<String, Integer>();
        readBook("pride-and-prejudice", ht, "Hash Table");
    }

    private static void readBook(String bookName, Map<String, Integer> map, String dsName){
        var book = new ArrayList<String>();
        if (FileOperation.readFile(bookName + ".txt", book)){
            out.println("___" + capitalize(bookName) + "___");
            out.println("Total words : " + book.size() + "\n");
        }

        // book.sort((a, b) -> a.compareTo(b)); // 直接先排好序, 比較退化成鏈結序列的 BST 與 AVLTree 的效能差距

        long start = nanoTime();
        for (var i : book){
            if (map.exist(i))
                map.set(i, map.get(i) + 1);
            else 
                map.add(i, 1);
        }
        long end = nanoTime();
        out.printf("[%s]\n", dsName);
        out.println("Total different words : " + map.getSize() + String.format("\nUsed : %f sec", (end - start) / 1000000000.));

        String word = "pride";
        out.println(String.format("Frequency of \"%s\" : %d", word, map.get(word)));
        word = "prejudice";
        out.println(String.format("Frequency of \"%s\" : %d", word, map.get(word)));
        
        if (map instanceof AVLMap){
            var tmp = (AVLMap) map;
            out.print("Is BST : ");
            out.println(tmp.isBST());
            out.print("Is Balanced : ");
            out.println(tmp.isBalanced());
            
            book.forEach(w -> {
                tmp.remove(w);
                if (!tmp.isBST()){
                    throw new RuntimeException("Not BST!");
                }
                if (!tmp.isBalanced()){
                    throw new RuntimeException("Not Balanced!");
                }
            });
        }
    }

    private static String capitalize(String tmp){
        var newString = new StringBuilder();
        boolean capSign = false;
        for (Character i : tmp.toCharArray()){
            if (!capSign && Character.isLowerCase(i)){
                newString.append(Character.toUpperCase(i));
                capSign = true;
            }
            else if (!Character.isLetterOrDigit(i)){
                newString.append(" ");
                capSign = false;
            }
            else 
                newString.append(i);
        }
        return newString.toString();
    }
}
