import java.util.ArrayList;
import static java.lang.System.*;

public class Main {
    public static void main(String [] args){
        var bstMap = new BSTMap<String, Integer>();
        readBook("pride-and-prejudice", bstMap, "Binary Search Tree Map");
        out.println();
        var AVLMap = new AVLTree<String, Integer>();
        readBook("a-tale-of-two-cities", AVLMap, "AVLMap, AVL Tree Map");
    }
    
    private static void readBook(String bookName, Map<String, Integer> map, String dsName){
        var book = new ArrayList<String>();
        if (FileOperation.readFile(bookName + ".txt", book)){
            out.println("___" + capitalize(bookName) + "___");
            out.println("Total words : " + book.size() + "\n");
        }

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
