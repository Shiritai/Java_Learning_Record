public class BST<E extends Comparable<E>> {
    // BST 需要元素具有可比較性
    // 本 BST 不重複儲存大小相同的元素 -> 可透過 1) 修改比較邏輯 2) 增加「個數」成員在 Node 裡
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /* add a new element in BST */
    public void add(E e){
        if (root == null){
            root = new Node(e);
            ++size;
        }
        else {
            add(root, e);
        }
    }
    
    /* use recursion to add an element in the tree from tmp */
    // this is my own version of addition
    private void add(Node tmp, E e){
        if (e.compareTo(tmp.e) < 0){
            if (tmp.left == null){
                tmp.left = new Node(e);
                ++size;
            }
            else {
                add(tmp.left, e); // call recur
            }
        }
        else (e.compareTo(tmp.e) > 0){
            if (tmp.right == null){
                tmp.right = new Node(e);
                ++size;
            }
            else {
                add(tmp.right, e); // call recur
            }
        }
        return;
    }

    /* add a new element in BST, Teacher's method */
    public void add_(E e){
        root = add_(root, e);
    }

    private Node add_(Node tmp, E e){
        if (tmp == null){
            ++size;
            return new Node(e);
        }
        if (e.compareTo(tmp.e) < 0){
            tmp.left = add_(tmp.left, e);
        }
        else if (e.compareTo(tmp.e) > 0){
            tmp.right = add_(tmp.right, e);
        }
        return tmp;
    }

}
