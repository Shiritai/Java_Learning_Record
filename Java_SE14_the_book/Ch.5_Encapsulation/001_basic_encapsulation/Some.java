public class Some {
    /* init area */
    {
        System.out.println("\n__Head of Some__");
        // System.out.println("do what you want here OwO\n");
        System.out.println();
    }

    private int some_int = 100; // default value
    private String some_str = "Eroiko";

    private final double final_double; // if we didn't initialize it in the following constructors, compiler will popped an error

    /*  Overload : we can define many Constructors with "different number of parameters" */
    
    // if we didn't make a constructor, compiler will automatically add a "Default Constructor" so we can call a (new) Constructor with no parameter
    public Some (int some_int, String some_str){
        this.some_int = some_int; // "this.*"  means the * parameter in the "Some" object
        this.some_str = some_str;
        this.final_double = 3.1415926;
        System.out.println("call with int and String");
    }

    // with auto-boxing, un-boxing
    public Some (int some_int){
        /* Bad Smell */
        this(some_int, ""); // noted that this line "must" be the first line of this (current) constructor!
        // this.some_int = some_int; // BAD SMELL, "repetition" may be harmful in programming
        System.out.println("call with int");
    }

    public Some (Integer some_int){
        this(some_int, "");
        System.out.println("call with Integer");
    }
    
    // an "Nullary" (Empty Constructor) example
    public Some (){
        this(0, "");
        System.out.println("call without parameters");
    }

    /* *
     * "Static"
     * 
     * static make the member of the class belongs to "the class" rather than "some instance"
     * i.e. 屬於整個「類別」，不為「個別」實例所擁有，此及類別與實例的關係
     * 
     * 其類別名稱就是它的名稱空間
     * 
     * e.g. the "main" function is a perfect example, if main belongs to each instance
     * and for each of them there is at least one constructor of the class in it
     * , then it'll recursively call main functions, which is really bad...
     * 
     * !!!!!  "this" should never be in any "static" members  !!!!!
     * !!!!!  "this" should never be in any "static" members  !!!!!
     * 
     *  */
    static final double PI = 3.1415926;
    
    static double toArc(double radius, double angle){ // 半徑轉弧長
        return radius * angle * PI / 180;
    }

    static {
        System.out.println("This line would execute when JVM loads Some.class! OwO");
    }
    
    public static void main(String[] args){
        var tmp1 = new Some(1);
        var tmp2 = new Some(new Integer(1)); // deprecated usage!
        var tmp3 = new Some((Integer) 1);
        var tmp4 = new Some();
        System.out.println(Some.PI); // the "static" member's name is in its namespace!
        System.out.println(Some.toArc(1, 360)); // the "static" member's name is in its namespace!
    }
}
