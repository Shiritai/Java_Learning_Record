interface Enum {
    int ADD = 0;
    int SUB = 1;
    int MUL = 2;
    int DIV = 3;
    int MOD = 4;
}

public class EnumInterface {

    static int num1 = 1;
    static int num2 = 2;

    public static void main(String [] args){
        int action = 10;

        System.out.println(
            switch (action){
                case Enum.ADD -> num1 + num2;
                case Enum.SUB -> num1 - num2;
                case Enum.MUL -> num1 * num2;
                case Enum.DIV -> num1 / num2;
                case Enum.MOD -> num1 % num2;
                default -> 1/0; // java.lang.ArithmeticException: / by zero
            }
        );
            
            play(DirEnum.ADD);
            play(DirEnum.MUL);
    }
        
    public static void play(DirEnum tmp){
        System.out.println(
            switch (tmp){
                case ADD -> num1 + num2;
                case SUB -> num1 - num2;
                case MUL -> num1 * num2;
                case DIV -> num1 / num2;
                case MOD -> num1 % num2;
                default -> 1/0; // java.lang.ArithmeticException: / by zero
            }
        );
    }
}
