public class Main {

    public static void main(String[] args) {

        var stack = new LinkedListStack<Integer>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
            System.out.println();
        }

        stack.pop();
        System.out.println(stack);
        System.out.println();
    }
}
