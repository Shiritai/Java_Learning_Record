import javax.swing.text.Segment;

public class Tmp {
    public static void main(String [] args){
        Integer [] numS = {-2, 0, 3, -5, 2, -1};
        var segTree = new SegmentTree<Integer>(numS, (a, b) -> a + b);
        System.out.println(segTree);
        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }
}
