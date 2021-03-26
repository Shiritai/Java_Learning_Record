public class Main {
    public static void main(String[] args){
        var bst = new BST<Integer>();
        int [] nums = {5, 3, 4, 6, 8, 2, 1};
        for (var i : nums){
            bst.add(i);
        }
        bst.preOrder();
        System.out.println();
        System.out.println(bst);
    }
}
