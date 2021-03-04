import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        var console = new Scanner(System.in);
        var a = console.nextInt();
        var b = console.nextInt();
        var c = console.nextInt();
        int result = (int)  (a + b + c) / 3;
        char rank = switch ((int) result / 10) {
            case 10, 9 -> 'A';
            case 8 -> 'B';
            case 7 -> 'C';
            case 6 -> 'D';
            case 5, 4, 3, 2, 1, 0 -> 'F';
            default -> 'Z'; // out of range
        };
        System.out.printf("%d\n%c\n", result, rank);
    }
}
