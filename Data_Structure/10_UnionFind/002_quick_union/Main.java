import java.util.Random;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args){
        int size = 50000;
        int testT = 50000;
        out.println("Quick Find : " + test(new QuickFind(size), testT) + " sec");
        out.println("Quick Union : " + test(new QuickUnion(size), testT) + " sec");
    }
    
    private static double test(UnionFind uf, int testTime){
        int size = uf.getSize();
        var rd = new Random();
        long start = System.nanoTime();

        for (int i = 0; i < testTime; i++){
            uf.union(rd.nextInt(testTime), rd.nextInt(testTime));
        }

        for (int i = 0; i < testTime; i++){
            uf.isConnected(rd.nextInt(testTime), rd.nextInt(testTime));
        }
        
        long end = System.nanoTime();
        return (end - start) / 1000000000.;
    }
}
