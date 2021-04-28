import java.util.ArrayList;
import static java.lang.System.*;

public class Main {
    public static void main(String [] args){
        // readBook("pride-and-prejudice");
        // out.println();
        // readBook("a-tale-of-two-cities");
        
        var tr = new Trie();
        var str = new String [] {"cat", "cause", "cute", "catch", "capacity"};
        tr.add(str[0]);
        tr.add(str[1]);
        tr.add(str[2]);
        tr.add(str[3]);
        tr.add(str[4]);
        out.println(tr.getSize());
        out.println(tr.contains(str[1]));
        out.println("------ After delete ------");
        tr.delete(str[0]);
        out.println(tr.getSize());
        out.println(tr.contains(str[0]));
        out.println(tr.contains(str[1]));
        out.println(tr.contains(str[2]));
        out.println(tr.contains(str[3]));
        out.println(tr.contains(str[4]));
    }
    
    private static void readBook(String bookName){
        out.println(capitalize(bookName));
        var book = new ArrayList<String>();
        FileOperation.readFile(bookName + ".txt", book);
        out.println("Total words : " + book.size());
        long start = nanoTime();
        var set = new BSTSet<String>();
        for (var i : book){
            set.add(i);
        }
        for (var word : book){
            set.exist(word);
        }
        long end = nanoTime();
        out.println("[BSTSet]\nTotal different words : " + set.getSize() + String.format("\nUsed : %f sec", (end - start) / 1000000000.));

        start = nanoTime();
        var trie = new Trie();
        for (var i : book){
            trie.add(i);
        }
        for (var word : book){
            trie.contains(word);
        }
        end = nanoTime();
        out.println("[Trie]\nTotal different words : " + trie.getSize() + String.format("\nUsed : %f sec", (end - start) / 1000000000.));
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
