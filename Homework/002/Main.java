import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        var console = new Scanner(System.in);
        int tmp = console.nextInt();
        int hun = (int) tmp / 100;
        int ten = (int) tmp / 10 - hun * 10;
        int one = (int) tmp % 10;

        if (tmp == hun * hun * hun + ten * ten * ten + one * one * one)
            System.out.printf("%d is a narcissistic number.", tmp);
        else 
            System.out.printf("%d is not a narcissistic number.", tmp);
        console.close();
    }
}
