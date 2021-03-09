import static java.lang.System.*;
import java.util.Scanner;

public class Hanoi {

    static void doHanoi(int disks, char A, char B, char C){
        if (disks == 1){
            out.printf("move disk No.%d from %c to %c\n", disks, A, C);
        }
        else {
            doHanoi(disks - 1, A, C, B);
            out.printf("move disk No.%d from %c to %c\n", disks, A, C);
            doHanoi(disks - 1, B, A, C);
        }
    }
    
    public static void main(String[] args){
        var console = new Scanner(in);
        int disks = console.nextInt();
        Hanoi.doHanoi(disks, 'A', 'B', 'C');
        console.close();
    }
}
