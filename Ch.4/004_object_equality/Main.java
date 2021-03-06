/* "==", "!= " of two object */
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        /* 
         * "new" means "build a new object", 
         * thus the reference of a and b below
         * are totally different object
         */
        var a = new BigDecimal("0.1"); // assign reference to BigDecimal
        var b = new BigDecimal("0.1"); // assign reference to BigDecimal
        var c = a;
        /* "==" means to check whether they are "the same" object */
        if (a == c){
            System.out.println("\"a == c\", which means the two objects have the same memory position.");
        }
        else {
            System.out.println("\"a != c\", which means the two objects have different memory position.");
        }
        /* use "object1.equals(object2)" to check whether they have the same value */
        if (a.equals(b)){
            System.out.println("\"a equals to b\", which means the two objects have the same value.");
        }
        else {
            System.out.println("\"a doesn't equal to b\", which means the two objects have different value.");
        }
    }
}
