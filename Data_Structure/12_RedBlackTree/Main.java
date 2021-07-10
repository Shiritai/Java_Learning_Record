import java.util.ArrayList;
import java.util.Random;
import static java.lang.System.*;

public class Main {
    public static void main(String [] args){
        // var bstMap = new BSTMap<String, Integer>();
        // readBook("pride-and-prejudice", bstMap, "Binary Search Tree Map");
        // out.println();
        // var AVLMap = new AVLMap<String, Integer>();
        // readBook("pride-and-prejudice", AVLMap, "AVL Tree Map");
        // out.println();
        // var RBMap = new RedBlackMap<String, Integer>();
        // readBook("pride-and-prejudice", RBMap, "Red Black Tree Map");
        // out.println("\n\n");

        // pureAddMap(10000000);
        pureSortedAddMap(20000000);
    }

    private static void pureAddMap(int len){
        var rd = new Random();
        var data = new ArrayList<Integer>(len); 
        for (int i = 0; i < len; ++i){
            data.add(rd.nextInt(Integer.MAX_VALUE));
        }

        var start = System.nanoTime();
        var bst = new BSTMap<Integer, Object>();
        data.forEach(i -> bst.add(i, null));
        var end = System.nanoTime();
        System.out.println("BST : " + (end - start) / 1000000000. + " s");
        
        start = System.nanoTime();
        var avl = new AVLMap<Integer, Object>();
        data.forEach(i -> avl.add(i, null));
        end = System.nanoTime();
        System.out.println("AVL : " + (end - start) / 1000000000. + " s");
        
        start = System.nanoTime();
        var rb = new RedBlackMap<Integer, Object>();
        data.forEach(i -> rb.add(i, null));
        end = System.nanoTime();
        System.out.println("Red Black : " + (end - start) / 1000000000. + " s");
    }

    private static void pureSortedAddMap(int len){
        var rd = new Random();
        var data = new ArrayList<Integer>(len); 
        for (int i = 0; i < len; ++i){
            data.add(rd.nextInt(Integer.MAX_VALUE));
        }
        data.sort(Integer::compareTo);
        
        var start = System.nanoTime();
        var avl = new AVLMap<Integer, Object>();
        data.forEach(i -> avl.add(i, null));
        var end = System.nanoTime();
        System.out.println("AVL : " + (end - start) / 1000000000. + " s");
        
        start = System.nanoTime();
        var rb = new RedBlackMap<Integer, Object>();
        data.forEach(i -> rb.add(i, null));
        end = System.nanoTime();
        System.out.println("Red Black : " + (end - start) / 1000000000. + " s");
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
                map.change(i, map.get(i) + 1);
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

        if (map instanceof RedBlackMap){
            // var tmp = (RedBlackMap) map;
            // tmp.inOrder();
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
