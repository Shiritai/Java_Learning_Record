public class LinkedList<E> {

    private class Node { // inner class
        public E e; // "public" so that "LinkedList" can freely access "Node"s
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

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void insertFront(E e){
        // var tmp = new Node(e);
        // tmp.next = head;
        // head = tmp;
        head = new Node(e, head); // elegant OwO, this line equals to the three lines above!

        ++size;
    }

    public void insert(E e, int position){ // rearly used, just for practice
        if (position < 0 || position > size){
            throw new IllegalArgument("Position of insertion is out of range!");
        }
        else if (position == 0){ // NOT ELEGANT ENOUGH!!! -> 引入虛擬頭節點
            insertFront(e);
        }
        else {
            Node tmp = head;
            while (position > 1 && tmp != null){
                tmp = tmp.next;
                --position;
            }
            // Node newNode = new Node(e, tmp.next);
            // tmp.next = newNode;
            tmp.next = new Node(e, tmp.next); // more elegantly OwO

            ++size;
        }
    }

    public void insertBack(E e){
        Node tmp = head;
        while (tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node(e);
    }
}
