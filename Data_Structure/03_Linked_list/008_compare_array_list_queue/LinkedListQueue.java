public class LinkedListQueue<E> implements Queue<E>{

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

    private Node head, back; // use "back" node to make sure that we can insert front node is O(1)
    private int size;

    public LinkedListQueue(){
        head = null;
        back = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void enqueue(E e){
        if (back == null){ // i.e. head == null
            back = new Node(e);
            head = back;
        }
        else {
            back.next = new Node(e, back.next);
            back = back.next;
        }
        ++size;
    }

    @Override
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        Node tmp = head;
        head = head.next;
        tmp.next = null;
        
        if (head == null){
            back = null;
        }
        
        --size;
        return tmp.e;
    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        return head.e;
    }
    
    @Override
    public String toString(){
        StringBuilder text = new StringBuilder(String.format("Queue : size = %d\n(front) [", size));
        Node tmp = head.next;
        while (tmp != null){
            text.append(tmp + " -> "); // notice that we use tmp.toString() method
            tmp = tmp.next;
        }
        text.append("null] (back)");
        return text.toString();
    }
}
