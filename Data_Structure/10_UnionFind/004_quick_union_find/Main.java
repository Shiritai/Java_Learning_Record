import java.util.Random;
import static java.lang.System.*;

public class Main {
    public static void main(String[] args){
        int size = 5000000;
        int testT = 5000000;
        out.println("Quicker Union : " + test(new QuickerUnion(size), testT) + "sec");
        // out.println("Quickest Union : " + test(new QuickestUnion(size), testT) + "sec");
        out.println("Quick Union Find based on er : " + test(new QuickUnionFind2(size), testT) + " sec");
        out.println("Quick Union Find based on est : " + test(new QuickUnionFind1(size), testT) + " sec");
        out.println("Quick Union Find based on er (recur path compress) : " + test(new QuickUnionFind(size), testT) + " sec");
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
