import java.util.ArrayList;
import static java.lang.System.*;

public class Main {
    public static void main(String [] args){
        readBook("pride-and-prejudice");
        out.println();
        readBook("a-tale-of-two-cities");
    }
    
    private static void readBook(String bookName){
        out.println(capitalize(bookName));
        var book = new ArrayList<String>();
        FileOperation.readFile(bookName + ".txt", book);
        out.println("Total words : " + book.size());
    
        var set = new BSTSet<String>();
        for (var i : book){
            set.add(i);
        }
        out.println("Total different words : " + set.getSize());
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
