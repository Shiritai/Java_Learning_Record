import java.util.ArrayList;
import java.util.Scanner;
// import static java.lang.System.*;

public class Main {
    public static void main(String args[]) {
        // var console = new Scanner(in);
        // out.printf("%d %s", console.nextInt() + console.nextInt() + console.nextInt(), console.next());
        // console.close();
        System.out.println(new ArrayList<Integer>().getClass() == new ArrayList<String>().getClass()); // true
        System.out.println(new ArrayList<Integer>().getClass().equals(new ArrayList<String>().getClass())); // true
    }
}
