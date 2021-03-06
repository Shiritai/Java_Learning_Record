public class FindNum {
    public static void main(String[] args) {
        int [] numbers = {1, 10, 31, 33, 37, 48, 60, 70, 80};
        if (args.length < 1){
            System.out.println("Please add the number you'd like to find to the argument and try again!");
        }
        else {
            int find = Integer.parseInt(args[0]);
            boolean found = false;
            for (int i = 0; i < numbers.length; ++i){
                if (numbers[i] == find){
                    System.out.printf("%d is at the index : %d", find, i);
                    found = true;
                }
            }
            if (!found){
                System.out.println("-1");
            }
        }
    }
}