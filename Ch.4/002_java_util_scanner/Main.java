/* conventionally, package named "java...." is a class of "Standard API" */
import java.util.Scanner; // from standard API import class "java.util.scanner"

public class Main {
    public static void main(String[] args) {
        // "System.in is a InputStream", used to construct "Scanner"
        var console = new Scanner(System.in);
        var number = (int) (Math.random() * 10);
        var guess = -1;
        do {
            System.out.println("Guess a number from 0 - 9");
            /* 
             * readInt() :
             * read stdin and check whether there is a blank or a carriage return
             * if yes, it'll try to scan the in_stream as an "integer"
             * Similarly, there some other functions like this:
             * -> nextByte(), nextShort(), nextLong(), nextFloat(), nextDouble(), nextBoolean()
             * or a string (end at a blank or a carriage return)
             * -> next()
             * or a whole line
             * -> nextLine()
            */
            guess = console.nextInt();
        } while (guess != number);
        System.out.println("ATARI DAZE!");
        console.close();
    }
}