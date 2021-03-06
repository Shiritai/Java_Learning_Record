/* please add input argument to assign how many fibs you'd like to see. */
public class Fibonacci {
    public static void main(String[] args){
        System.out.printf("Number of arguments : %d\n", args.length); // Differ from C, the EXECUTE_FILENAME doesn't regard as an argument
        if (args.length < 1){
            System.out.println("Please add input argument to assign how many \"fibs\" you'd like to see.");
        }
        else {
            int a0 = 0, a1 = 1, tmp = 0;
            var fibs = Integer.parseInt(args[0]);
            for (var i = 0; i <= fibs; ++i){
                System.out.printf("%d ", a1);
                tmp = a1;
                a1 += a0;
                a0 = tmp;
            }
        }
    }
}
