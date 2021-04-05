import java.util.Random;

public class Main {
    public static void main(String [] args){
        int n = 10000;

        var tmp = new MaxHeap<Integer>();
        Random random = new Random();
        for (int i = 0; i < n; ++i)
            tmp.add(random.nextInt(Integer.MAX_VALUE));
        
        var arr = new Integer[n];
        for (int i = 0; i < n; ++i)
            arr[i] = tmp.removeMax();
        
        for (int i = 0; i < n - 1; ++i)
            if (arr[i] < arr[i + 1])
                throw new IllegalArgumentException("Not sorted yet!");
        System.out.println("Sorted");

    }
}
