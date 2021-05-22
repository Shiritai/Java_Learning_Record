public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    private Node root;
    private int size;
    
    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public boolean isEmpty(){ return size == 0;}

    @Override
    public int getSize(){ return size;}

    @Override
    public void add(K key, V value){
        root = add(root, key, value);
    }

    /* Recur, 以 cur 為 root node, 插入 (key, value) */
    private Node add(Node cur, K key, V value){
        if (cur == null){
            ++size;
            return new Node(key, value);
        }
        if (key.compareTo(cur.key) < 0)
            cur.left = add(cur.left, key, value);
        else if (key.compareTo(cur.key) > 0)
            cur.right = add(cur.right, key, value);
        else // key.compareTo(cur.key) == 0
            cur.value = value;
        return cur; // for recur
    }

    private Node getNode(Node tmp, K key){
        if (tmp != null){
            if (key.compareTo(tmp.key) == 0)
                return tmp;
            else if (key.compareTo(tmp.key) < 0)
                return getNode(tmp.left, key);
            else // key.compareTo(cur.key) > 0
                return getNode(tmp.right, key);
        }
        return null;
    }

    @Override
    public boolean exist(K key){ return getNode(root, key) != null;}

    @Override
    public V get(K key){
        Node tmp = getNode(root, key);
        return tmp == null ? null : tmp.value;
    }
    
    @Override
    public void set(K key, V value){
        Node tmp = getNode(root, key);
        if (tmp != null)
            tmp.value = value;
        else
            throw new IllegalArgumentException(key + "does not exist!");
    }

    @Override
    public V remove(K key){
        Node tmp = getNode(root, key);
        if (tmp != null){
            root = remove(root, key);
            return tmp.value;
        }
        return null;
    }

    private Node remove(Node cur, K key){
        if (cur != null){
            if (key.compareTo(cur.key) == 0){
                if (cur.left == null){
                    Node comb = cur.right;
                    comb.right = null; // comb.left is already == null
                    return comb;
                }
                else if (cur.right == null){
                    Node comb = cur.left;
                    comb.left = null; // comb.right is already == null
                    return comb;
                }
                else { // both of cur's child exist!
                    Node successor = cur.right;
                    Node parentSuc = null;
                    while (successor.left != null){
                        parentSuc = successor;
                        successor = successor.left;
                    }
                    
                    successor.left = cur.left;
                    
                    if (parentSuc != null){
                        parentSuc.left = successor.right;
                        successor.right = cur.right;
                    }

                    cur.left = cur.right = null;
                    return successor;
                }
            }
            else if (key.compareTo(cur.key) < 0)
                cur.left = remove(cur.left, key);
            else // key.compareTo(cur.key) < 0
                cur.right = remove(cur.right, key);
            return cur;
        }
        return null;
    }
    
}
