import java.math.BigDecimal; // for better precision

public class Main {
    public static void main(String[] args){
        var operand1 = new BigDecimal("3.1415926");
        var operand2 = new BigDecimal(".1415926");

        var ADD = operand1.add(operand2);
        var SUB = operand1.subtract(operand2);
        var MUL = operand1.multiply(operand2);
        System.out.printf("add : %f, sub : %f, mul : %f\n", ADD, SUB, MUL); // isn't this pretty good?
        
        var op = new BigDecimal(3.);
        System.out.printf("%b\n", operand2.add(op).equals(operand1)); // add and then compare, DON'T USE "=="
    }
}
