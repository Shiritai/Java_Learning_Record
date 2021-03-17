public class LinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node();
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    
    public void insert(E e, int position){
        if (position < 0 || position > size){
            throw new IllegalArgument("Position of insertion is out of range!");
        }
        else {
            Node tmp = dummyHead;
            while (position > 0 && tmp != null){
                tmp = tmp.next;
                --position;
            }
            tmp.next = new Node(e, tmp.next);
            ++size;
        }
    }
    
    public void insertFront(E e){
        insert(e, 0);
    }
    
    public void insertBack(E e){
        insert(e, size);
    }
}
