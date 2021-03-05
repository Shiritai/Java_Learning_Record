public class Main {
    /* Wrapper (包裹器) and Unboxing (拆箱), Autoboxing (自動ㄓㄨㄤ箱) of basic types in Java */
    public static void main(String[] args){
        int intData = 9123;
        int divisor = 4;
        /* a deprecated usage of API 
         * well, some warning message should popped up...
         */
        var IntWrapper = new Integer(intData);
        System.out.printf("in the wrapper is : %d\n", IntWrapper);
        System.out.printf("Applied \"doubleValue()\" and divide by %d : %d", divisor, IntWrapper.doubleValue() / divisor);
    }
}
