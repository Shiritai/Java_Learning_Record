import java.util.Random;

public class Main {
    public static void main(String [] args){
        int n = 10000000;
        Random random = new Random();
        var data = new Integer[n];
        for (int i = 0; i < n; ++i){
            data[i] = random.nextInt(Integer.MAX_VALUE);
        }
         
        long start = System.nanoTime();
        var heap = new MaxHeap<Integer>();
        for (int i = 0; i < n; ++i){
            heap.add(data[i]);
        }
        var arr = new Integer[n];
        for (int i = 0; i < n; ++i){
            arr[i] = heap.removeMax();
        }
        checkSorted(arr, n);
        long end = System.nanoTime();
        System.out.println("Not heapify : " + (end - start) / 1000000000. + "sec");
        
        start = System.nanoTime();
        var heapify = new MaxHeap<Integer>(data);
        arr = new Integer[n];
        for (int i = 0; i < n; ++i){
            arr[i] = heapify.removeMax();
        }
        checkSorted(arr, n);
        end = System.nanoTime();
        System.out.println("Heapify : " + (end - start) / 1000000000. + "sec");

    }
    static void checkSorted(Integer[] arr, int n){
        for (int i = 0; i < n - 1; ++i)
            if (arr[i] < arr[i + 1])
                throw new IllegalArgumentException("Not sorted yet!");
        System.out.println("Sorted");    
    }
}
