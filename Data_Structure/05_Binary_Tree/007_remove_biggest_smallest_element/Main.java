import java.util.Random;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        var bst = new BST<Integer>();
        int range = 1000;
        var random = new Random();
        for (int i = 0; i < range; ++i){
            bst.add(random.nextInt(range));
        }
        var list = new ArrayList<Integer>();
        while (!bst.isEmpty()){
            list.add(bst.removeMin());
        }
        for (int i = 0; i < list.size() - 1; ++i){
            if (list.get(i) > list.get(i + 1)){
                throw new IllegalArgumentException("Something is Wrong...");
            }
        }
        System.out.println("removeMin seems to work correctly");
        
        for (int i = 0; i < range; ++i){
            bst.add(random.nextInt(range));
        }
        list = new ArrayList<Integer>();
        while (!bst.isEmpty()){
            list.add(bst.removeMax());
        }
        for (int i = 0; i < list.size() - 1; ++i){
            if (list.get(i) < list.get(i + 1)){
                throw new IllegalArgumentException("Something is Wrong...");
            }
        }
        System.out.println("removeMax seems to work correctly");

    }
}
