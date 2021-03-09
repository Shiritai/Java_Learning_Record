import static java.lang.System.*; // this line include the following two lines
// import static java.lang.System.out;
// import static java.lang.System.in;

public class Other {
    /* *
     * Variable-length Argument (不定長度引數)
     * 
     * well, this is another compiler sugar
     * which "int..." is actually "int []" (or more precisely : "new int[] {1, 2, ...}")
     * 
     *  */
    public static void sumWithMessage(String printInfo, int... num){
        out.printf("%s ", printInfo);
        int sum = 0;
        for (var tmp : num){
            sum += tmp;
        }
        out.println(sum);
    }
    public static void main(String[] args){
        out.println("Ya, I like being lazy!");
        Other.sumWithMessage("I am Eroiko and my lucky number is :", 1, 2, 3, 4, 5, 100);
    }

    /* *
     * Call by Value
     * 
     * the "ONLY" calling method in Java
     * 
     *  */

}
