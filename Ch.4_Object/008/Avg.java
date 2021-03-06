/* please run this code with the command below :
 * 
 *  cd "YOUR_DIRECTORY" ; if ($?) { javac Avg.java } ; if ($?) { java Avg 4 8 7 6 3 }
 * 
 */

public class Avg {
    public static void main(String[] args){
        var sum = .0;
        for (var arg : args){
            sum += Double.parseDouble(arg);
        }
        System.out.println(sum / args.length);
    }
}
