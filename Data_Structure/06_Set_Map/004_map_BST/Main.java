import java.util.ArrayList;
import static java.lang.System.*;

public class Main {
    public static void main(String [] args){
        readBook("pride-and-prejudice");
        out.println();
        readBook("a-tale-of-two-cities");
    }
    
    private static void readBook(String bookName){
        var book = new ArrayList<String>();
        if (FileOperation.readFile(bookName + ".txt", book)){
            out.println("___" + capitalize(bookName) + "___");
            out.println("Total words : " + book.size() + "\n");
            
            long start = nanoTime();
            var listMap = new LinkedListMap<String, Integer>();
            for (var i : book){
                if (listMap.exist(i))
                    listMap.change(i, listMap.get(i) + 1);
                else 
                    listMap.add(i, 1);
            }
            long end = nanoTime();
            out.println("___[Linked List Map]___");
            out.println("Total different words : " + listMap.getSize() + String.format("\nUsed : %f sec", (end - start) / 1000000000.));
            String word = "pride";
            out.println(String.format("Frequency of \"%s\" : %d", word, listMap.get(word)));
            word = "prejudice";
            out.println(String.format("Frequency of \"%s\" : %d", word, listMap.get(word)));

            out.println();

            start = nanoTime();
            var bstMap = new BSTMap<String, Integer>();
            for (var i : book){
                if (bstMap.exist(i))
                    bstMap.change(i, bstMap.get(i) + 1);
                else 
                    bstMap.add(i, 1);
            }
            end = nanoTime();
            out.println("___[Binary Search Tree Map]___");
            out.println("Total different words : " + bstMap.getSize() + String.format("\nUsed : %f sec", (end - start) / 1000000000.));
            word = "pride";
            out.println(String.format("Frequency of \"%s\" : %d", word, bstMap.get(word)));
            word = "prejudice";
            out.println(String.format("Frequency of \"%s\" : %d", word, bstMap.get(word)));
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
