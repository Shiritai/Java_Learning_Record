public class LinkedListMap<K, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
        public Node(K key){ this(key, null, null);}
        public Node(){ this(null, null, null);}

        @Override
        public String toString(){ return key.toString() + ":" + value.toString();}
    }
    
    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize(){ return size;}

    @Override
    public boolean isEmpty(){ return size == 0;}

    private Node getNode(K key){
        Node cur = dummyHead.next;
        while (cur != null){
            if (key.equals(cur.key))
                return cur;
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean exist(K key){ return getNode(key) != null;}

    @Override 
    public V get(K key){
        Node tmp = getNode(key);
        return tmp == null ? null : tmp.value;
    }

    @Override
    public void add(K key, V value){
        Node tmp = getNode(key);
        if (tmp == null){
            dummyHead.next = new Node(key, value, dummyHead.next);
            ++size;
        }
        else
            tmp.value = value;
    }

    @Override
    public void change(K key, V value){
        Node tmp = getNode(key);
        if (tmp != null)
            tmp.value = value;
        else
            throw new IllegalArgumentException(key + " does not exist!");
    }

    @Override
    public V remove(K key){
        Node prev = dummyHead;
        while (prev.next != null && key.equals(prev.next.key))
            prev = prev.next;
        if (prev.next != null){ // found certain node!
            Node killed = prev.next;
            prev.next = killed.next;
            killed.next = null;
            --size;
            return killed.value;
        }
        return null;
    }
}
