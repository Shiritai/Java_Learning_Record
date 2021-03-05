import java.util.Arrays; // for fill()

public class Main {
    public static void main(String[] args){
        /* Array : built by basic type */

        /* Array IS AN OBJECT in Java!!!!! 
         * See the cute Yellow highlight thanks for Atom Dark Theme OwO
         */
        int [] score = {1, 2, 3, 4, 5, 6, 7, 8};
        
        // well, C/C++ style also pass the compilation... but we're in Java
        // int c_score [] = {4, 5, 6};

        /* use "for" loop to traverse the array */
        for (var i = 0; i < score.length; ++i){ // ARRAY.length = the length of the ARRAY
            System.out.printf("%d ", score[i]++);
        }
        System.out.println();
        
        /* Actually we have "enhanced for loop" to do the same thing
         * which is also a COMPILER SUGAR, the efficiency won't change
         */
        for (int num : score){
            System.out.printf("%d ", num);
        }
        System.out.println("\n");
        /* Decompile the code above ...
         * 
         * int[] num = score;
         * int i = score.length;
         * for(int j = 0; j < i; j++){
         *     int k = num[j];
         *     ...
         * }
         */

        /* two dimension array
         * high layer array is consist of 1D-arrays
         * 
         * For example, the values in 2D-array are "THE REFERENCEs" of 1D-arrays.
         * 
         * Also we can directly declare a vary-length array...
         */
        int [][] twoDimArray = {{0, 1}, {2, 3, 4, 5}, {6, 7, 8}}; // we can see the type as (int[])[]
        
        /* normal traverse way... */
        for (var i = 0; i < twoDimArray.length; ++i){
            for (var j = 0; j < twoDimArray[i].length; ++j){ // the condition is vary from C language!!!
                System.out.printf("%d ", twoDimArray[i][j]++);
            }
            System.out.println();
        }
        System.out.println();
        
        /* use enhanced for loop..., the next line is vary from C language */
        for (int[] row : twoDimArray){ // notice that array IS AN OBJECT, not merely a continuous MEM space
            for (int val : row){
                System.out.printf("%d ", val);
            }
            System.out.println();
        }
        System.out.println();
        
        /* new a array object and initialize it */
        // int [] data = new int[10]; // since this is a local variable...
        var data = new int[10]; // can use the type "var" after Java SE 10, data will point to "null"
        for (int val : data){
            System.out.printf("%d ", val);
        }
        System.out.println();

        Arrays.fill(data, 99); // init all value to "99"
        for (int val : data){
            System.out.printf("%d ", val);
        }
        System.out.println();
    }
}