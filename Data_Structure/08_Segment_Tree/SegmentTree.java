public class SegmentTree<E>{
    private E [] data;
    private E [] tree;
    private Merger<E> merger;

    // class Node {
    //     int treeInd;
    //     int LHS;
    //     int RHS;
    //     Node(int treeInd, int LHS, int RHS){
    //         this.treeInd = treeInd;
    //         this.LHS = LHS;
    //         this.RHS = RHS;
    //     }
    // }

    public SegmentTree(E [] arr, Merger<E> merger){
        this.merger = merger;
        data = (E []) new Object [arr.length];
        for (int i = 0; i < arr.length; ++i){
            data[i] = arr[i];
        }
        tree = (E []) new Object [arr.length * 4];
        buildSegmentTree(0, 0, data.length - 1);    
    }

    /* 當前創建之線段樹的根節點, 此線段 (Segment) 的左右界, Recur */
    private void buildSegmentTree(int treeIndex, int l, int r){
        if (l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftInd = leftChild(treeIndex);
        int rightInd = rightChild(treeIndex);
        int mid = l + (r - l) / 2;
        buildSegmentTree(leftInd, l, mid);
        buildSegmentTree(rightInd, mid + 1, r);
        tree[treeIndex] = merger.merge(tree[leftInd], tree[rightInd]); // 視應用場景而異!
    }

    private int checkIndexRange(int uncheckedIndex){
        if (uncheckedIndex < 0 || uncheckedIndex >= data.length){
            throw new IllegalArgumentException("Index out of range!");
        }
        return uncheckedIndex;
    }

    public E get(int index){ return data[checkIndexRange(index)];}
    public int getSize(){ return data.length;}

    /* 左右子節點之算法, 順帶一提，本資結不須要尋找父節點的函數 */
    private int leftChild(int index){ return 2 * index + 1;}
    private int rightChild(int index){ return 2 * index + 2;}

    /* return data[i ~ r] 的數值 */
    public E query(int queryL, int queryR){
        if (checkIndexRange(queryL) > checkIndexRange(queryR)){
            throw new IllegalArgumentException("Left index is bigger than right index!");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    /* 在 Segment Tree [l ~ r] 查找 queryL ~ queryR 的值 */
    private E query(int treeIndex, int l, int r, int queryL, int queryR){
        if (l == queryL && r == queryR){
            return tree[treeIndex];
        }

        int mid = l + (r - l) / 2;
        int leftInd = leftChild(treeIndex);
        int rightInd = rightChild(treeIndex);

        if (queryL > mid){
            return query(rightInd, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid){
            return query(leftInd, l, mid, queryL, queryR);
        }
        return merger.merge(query(leftInd, l, mid, queryL, mid), query(rightInd, mid + 1, r, mid + 1, queryR));
    }
    
    public void set(int index, E e){
        data[checkIndexRange(index)] = e;
        set(0, 0, data.length - 1, index, e);
    }
    
    private void set(int treeIndex, int l, int r, int index, E e){
        if (l == r){
            tree[treeIndex] = e;
            return;
        }
        int mid = l + (r - l) / 2;
        int leftInd = leftChild(treeIndex);
        int rightInd = rightChild(treeIndex);
    
        if (index > mid){
            set(rightInd, mid + 1, r, index, e);
        } else { // index <= mid
            set(leftInd, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftInd], tree[rightInd]);
    }

    @Override
    public String toString(){
        var content = new StringBuilder();
        content.append('[');
        for (var i : tree){
            content.append((i == null) ? "null" : i).append(", ");
        }
        content.deleteCharAt(content.length() - 1).deleteCharAt(content.length() - 1).append(']');
        return content.toString();
    }
}
