/*
 * Author : Shiritai (楊子慶, or Eroiko on Github) at 2021/07/14.
 * See https://github.com/Shiritai/wallpaper_master for more information.
 * Created using VSCode.
 * This is a LLRBT, without implementation of node deletion
 */

public class RedBlackTree<K extends Comparable<K>, V> {
    
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;
        
        public Node(K key, V value){
            this.key = key;
            this.value = value;
            this.left = this.right = null;
            this.color = RED; // 紅色表要跟其他節點融合
        }
    }

    private Node root;
    int size;

    public RedBlackTree(){
        root = null;
        size = 0;
    }

    public int getSize(){ return size; }
    public boolean isEmpty(){ return size == 0; }

    public boolean isRed(Node cur){
        if (cur == null){
            return false; // 所有葉節點都是 Black, 因此非 Red
        }
        return cur.color == RED;
    }

    public void add(K key, V value){
        root = add(root, key, value);
        root.color = BLACK; // 保持紅黑樹根節點為 Black
    }

    private Node add(Node cur, K key, V value){
        if (cur == null){
            ++size;
            return new Node(key, value); // default 插入 red node
        }

        /* 依照 BST 規則尋找加入 node 的位置 */
        if (key.compareTo(cur.key) < 0){
            cur.left = add(cur.left, key, value);
        }
        else if (key.compareTo(cur.key) > 0){
            cur.right = add(cur.right, key, value);
        }
        else {
            cur.value = value;
        }

        /* 維護紅黑樹性質, 注意以下三個條件非互斥, 而是循序檢查 -> 循序進行 */
        /* 1. (L, i.e. 左子樹) R -> (對左子樹) 左旋轉 */
        if (isRed(cur.right) && !isRed(cur.left)){
            cur = leftRotate(cur);
        }
        /* 2. LL -> 右旋轉 */
        if (isRed(cur.left) && isRed(cur.left.left)){
            cur = rightRotate(cur);
        }
        /* 3. 是否需要顏色翻轉 */
        if (isRed(cur.left) && isRed(cur.right)){
            flipColors(cur);
        }
        return cur;
    }

    private Node leftRotate(Node cur){
        var newRoot = cur.right;
        cur.right = newRoot.left;
        newRoot.left = cur;

        newRoot.color = cur.color;
        cur.color = RED;
        return newRoot;
    }

    private Node rightRotate(Node cur){
        var newRoot = cur.left;
        cur.left = newRoot.right;
        newRoot.right = cur;

        newRoot.color = cur.color;
        cur.color = RED;
        return newRoot;
    }

    /** 請確定好要翻轉顏色後再調用 */
    private void flipColors(Node cur){
        cur.color = RED;
        cur.left.color = BLACK;
        cur.right.color = BLACK;
    }

    public void change(K key, V value){
        var tmp = getNode(root, key);
        if (tmp != null){
            tmp.value = value;
        }
        else {
            throw new IllegalArgumentException(key + "does not exist!");
        }
    }

    private Node getNode(Node cur, K key){
        if (cur != null){
            if (key.compareTo(cur.key) == 0){
                return cur;
            }
            else if (key.compareTo(cur.key) < 0){
                return getNode(cur.left, key);
            }
            else {
                return getNode(cur.right, key);
            }
        }
        return null;
    }

    public V get(K key){
        var tmp = getNode(root, key);
        return (tmp == null) ? null : tmp.value;
    }

    public boolean exist(K key){ return getNode(root, key) != null; }

    public V remove(K key){
        var tmp = getNode(root, key);
        if (tmp == null){
            return null;
        }
        root = remove(root, key);
        return tmp.value;
    }

    private Node remove(Node cur, K key){
        if (cur != null){
            if (key.compareTo(cur.key) < 0){
                cur.left = remove(cur.left, key);
            }
            else if (key.compareTo(cur.key) > 0){
                cur.right = remove(cur.right, key);
            }
            else {
                --size;
                Node successor;
                if (cur.left == null){
                    successor = cur.right;
                    cur.right = null;
                }
                else if (cur.right == null){
                    successor = cur.left;
                    cur.left = null;
                }
                else {
                    /* find successor */
                    successor = cur.right;
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
        }
        return cur;
    }
    
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node cur){
        if (cur != null){
            inOrder(cur.left);
            System.out.println(cur.key.toString() + " : " + cur.value);
            inOrder(cur.right);
        }
    }

}
