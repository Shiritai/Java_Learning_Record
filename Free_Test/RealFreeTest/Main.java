import java.util.Scanner;
import static java.lang.System.*;

public class Main {
    public static void main(String args[]) {
        var console = new Scanner(in);
        out.printf("%d %s", console.nextInt() + console.nextInt() + console.nextInt(), console.next());
        console.close();
    }
}
