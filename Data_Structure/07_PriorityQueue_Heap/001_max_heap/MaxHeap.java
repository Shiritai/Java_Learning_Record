public class MaxHeap<E extends Comparable<E>> {
    private Array<E> arr;

    public MaxHeap(int size){
        arr = new Array<E>(size);
    }
    
    public MaxHeap(){
        arr = new Array<>();
    }

    public int size(){ return arr.getSize();}

    public boolean isEmpty(){ return arr.isEmpty();}

    /* Return its parent / child index */
    private int parent(int i){ return (i - 1) / 2;}
    private int leftChild(int i){ return i * 2 + 1;}
    private int rightChild(int i){ return i * 2 + 2;}

    public E peekMax(){
        if (arr.getSize() == 0)
            throw new IllegalArgumentException("No data...");
        return arr.getElement(0);
    }

    /* 嘗試將 index i 給 shift up */
    private void shiftUp(int i){
        while (i > 0 && arr.getElement(parent(i)).compareTo(arr.getElement(i)) < 0){
            arr.swap(i, parent(i));
            i = parent(i);
        }
    }

    /* 嘗試將 index i 給 shift down */
    private void shiftDown(int i){
        while (leftChild(i) < arr.getSize()){
            int newInd = leftChild(i);
            if (newInd + 1 < arr.getSize() && arr.getElement(newInd).compareTo(arr.getElement(newInd + 1)) < 0)
                ++newInd;
            if (arr.getElement(i).compareTo(arr.getElement(newInd)) >= 0)
                break;
            arr.swap(i, newInd);
            i = newInd;
        }
    }
    
    public void add(E e){
        arr.addLast(e);
        shiftUp(arr.getSize() - 1);
    }

    public E removeMax(){
        E tmp = peekMax();
        arr.overWrite(0, arr.getElement(arr.getSize() - 1));
        arr.deleteLast();
        shiftDown(0);
        return tmp;
    }
}
