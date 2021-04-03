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
            throw new IllegalArgumentException("Position of insertion is out of range!");
        }
        Node tmp = dummyHead;
        while (position > 0){
            tmp = tmp.next;
            --position;
        }
        tmp.next = new Node(e, tmp.next);
        ++size;
    }
    
    public void insertFront(E e){
        insert(e, 0);
    }
    
    public void insertBack(E e){
        insert(e, size);
    }

    public E getElement(int position){
        if (position < 0 || position >= size){
            throw new IllegalArgumentException("Illegal position.");
        }
        Node tmp = dummyHead.next; // notice here OwO
        while (position > 0){
            tmp = tmp.next;
            --position;
        }
        return tmp.e;
    }

    public E getFirstElement(){
        return (dummyHead.next).e;
    }

    public E getLastElement(){
        Node tmp = dummyHead;
        while (tmp.next != null)
            tmp = tmp.next;
        return tmp.e;
    }

    public void replaceElement(E e, int position){
        if (position < 0 || position >= size){
            throw new IllegalArgumentException("Replace failed, illegal position!");
        }
        Node tmp = dummyHead.next;
        while (position > 0){
            tmp = tmp.next;
            --position;
        }
        tmp.e = e;
    }

    public E deleteElement(E e){
        Node tmp = dummyHead;
        while (tmp.next != null && !e.equals(tmp.next.e)){
            tmp = tmp.next;
        }
        if (e.equals(tmp.next.e)){
            Node delNode = tmp.next;
            tmp.next = delNode.next;
            delNode.next = null; // let JVM free delNode in the end of this method
            --size;
            return delNode.e;
        }
        else {
            System.out.println("Data not found!");
            return null;
        }
    }

    public E delete(int position){
        if (position < 0 || position >= size){
            throw new IllegalArgumentException("Delete failed, position out of range.");
        }
        Node tmp = dummyHead;
        while (position > 0){
            tmp = tmp.next;
            --position;
        }
        Node delNode = tmp.next;
        tmp.next = delNode.next;
        delNode.next = null; // let JVM free delNode in the end of this method

        --size;
        return delNode.e;
    }

    public E deleteFront(){
        return delete(0);
    }

    public E deleteBack(){
        return delete(size - 1);
    }

    public boolean exist(E e){
        Node tmp = dummyHead.next;
        while (tmp != null){
            if (e.equals(tmp.e)){
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder(String.format("Linked List : size = %d\n(head) [", size));
        Node tmp = dummyHead.next;
        while (tmp != null){
            text.append(tmp + " -> "); // notice that we use tmp.toString() method
            tmp = tmp.next;
        }
        text.append("null] (last)");
        return text.toString();
    }
}
