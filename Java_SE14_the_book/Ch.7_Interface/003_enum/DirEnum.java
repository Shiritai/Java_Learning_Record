/* *
 * Enum is a special class in java, inherit from "java.lang.Enum"
 * Compiler will reject if we inherit "enum" class directly
 * */

public enum DirEnum {
    ADD, SUB, MUL, DIV, MOD
}

/* *
 * The code above will extend to:
 * 
 * public final class DirEnum extends Enum {
 *     // notice that the constructor has the type "PRIVATE"!!!
 *     // so we can't implement "enum" class directly
 *     private DirEnum(String s, int i){
 *         super(s, i)
 *     }
 *     public static final DirEnum ADD; 
 *     public static final DirEnum SUB; 
 *     public static final DirEnum MUL; 
 *     public static final DirEnum DIV; 
 *     public static final DirEnum MOD;
 *     ...
 *     static {
 *         ADD = new DirEnum("ADD", 0);    
 *         SUB = new DirEnum("SUB", 1);    
 *         MUL = new DirEnum("MUL", 2);    
 *         DIV = new DirEnum("DIV", 3);    
 *         MOD = new DirEnum("MOD", 4);    
 *     } 
 * }
 *  */
