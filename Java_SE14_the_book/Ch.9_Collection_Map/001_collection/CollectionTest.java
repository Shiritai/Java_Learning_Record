import java.util.*;
import static java.lang.System.*;

public class CollectionTest {
    public static void main(String [] args){
        var console = new Scanner(in);
        var words = tokenSet(console.nextLine());
        out.println(words.size());
        for (var i : words){
            out.println(i);
        }
        console.close();
    }

    static Set<String> tokenSet(String line){
        /* Implements of Collection (like HashSet) has constructor 
         * that take a collection as parameter 
         * */
        return new HashSet<String>(Arrays.asList(line.split(" "))); 
    }
}
