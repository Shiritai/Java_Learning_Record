public class Main {
    /* Wrapper (包裹器) and Unboxing (拆箱), Auto-boxing (自動ㄓㄨㄤ箱) of basic types in Java */
    public static void main(String[] args){
        int intData = 9123;
        int divisor = 4;
        /* 
         * Below shows a deprecated usage of API 
         * well, some warning message should popped up...
         */
        var IntWrapper = new Integer(intData);
        System.out.printf("IntWrapper : %d\n", IntWrapper);
        System.out.printf("Is IntWrapper greater than divisor ? %b\n", IntWrapper.compareTo(divisor)); // compareTo another Integer
        
        /* even don't let me use this...QQ */
        // System.out.printf("Applied \"doubleValue()\" and divide by %d : %d", divisor, IntWrapper.doubleValue() / divisor);
        
        System.out.println();
        /* 
         * Auto-boxing
         * LongAutoWrapper" will refer to "Integer" instance
         * Similarly, auto-boxing can also apply to other basic data types
         */
        // e.g.
        Long LongAutoWrapper = 0x7fffffffffffffffL;
        
        System.out.printf("LongAutoWrapper : %d\n", LongAutoWrapper);
        System.out.printf("Is LongAutoWrapper greater than IntWrapper ? %b\n", LongAutoWrapper.compareTo(IntWrapper.longValue()));
        
        
        /* More concisely, we can use expression below */
        Number toaruFloatWrapper = 3.1415926f;

        /* after we wrapped a box, we can unbox it to assign the value in it */
        
        float tmpFloat = toaruFloatWrapper.floatValue(); // auto-unboxing
        System.out.printf("auto-unboxed and assigned : %f\n", tmpFloat);
        
        /* code below shows some "auto-unboxing operation" */
        
        /* 
         * jshell> Integer number = 10;
         * number ==> 10.
         * 
         * // notice that if we use "Number" for auto-boxing,
         * // error will occur as the cmd below executed 
         * // since number is a double
         * 
         * // auto-unboxing and add 1
         * jshell> System.out.println(++number); 
         * 11
         * 
         * jshell> Boolean toaruBool = true;
         * toaruBool ==> true
         * 
         * // auto-unboxing and do logic operation
         * jshell> System.out.println(toaruBool && false); 
         * false
         */

        /* Behind "auto-unboxing"..., the COMPILER SUGAR (編譯器蜜糖) */
        // 1. the complier sugar
        Integer tmpInt = Integer.valueOf("100"); // may be implemented as "Integer tmpInt = 100;"

        System.out.println();
        // 2. what we need to notice...
        // 2-1 null
        /* code below can should pass the compilation, but... */

        // Integer tmpNullInt = null; // may be implemented as "Object localObject = null;"
        // int tmpNullIntAssign = tmpNullInt; // error occur during runtime
        
        /*  
         * may be implemented as "int tmpNullIntAssign = localObject.intValue();"
         * which result to "NullPointerException"
         */

        // 2-2 == or != ?
        /* when auto-wrapping 100 */
        Integer tmp1 = 100;
        Integer tmp2 = 100;
        System.out.printf("Is tmp1 == tmp2 ? %b\n", tmp1 == tmp2); // true!? (I'd expect to be false...)
        /* what about 200 ? */
        Integer tmp_1 = 200;
        Integer tmp_2 = 200;
        System.out.printf("Is tmp_1 == tmp_2 ? %b\n", tmp_1 == tmp_2); // false!!! so WHY!? OwO
        /* 
         * Let's see how "valueOf()" implement...
         * 
         * public static Integer valueOf(int i) {
         *     if (i >= IntegerCache.low && i <= IntegerCache.high) // default : low -> -128, high -> 127
         *         return IntegerCache.cache[i + (-IntegerCache.low)];
         *     return new Integer(i);
         * }
         * 
         * That is, if the int we'd like to assign 
         * is between "IntegerCache.high" and "IntegerCache.low", 
         * then it'll check whether it has boxed the same value.
         * If true, return the value directly,
         * if false, use "new" to construct a new Integer instance. 
         * 
         * The default value of IntegerCache.low cannot change during runtime,
         * while IntegerCache.high can change during the section starting JVM.
         * try add some parameter like "-Djava.lang.IntegerCache.high=200" and test what will change.
         * but this is a bit complicated...
         */

        /* in the end, just use "equals()" to compare two values in the objects OwO */
    }
}
