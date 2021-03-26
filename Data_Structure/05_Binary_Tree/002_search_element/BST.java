public class BST<E extends Comparable<E>>  {
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

    /* add a new element in BST, Teacher's method */
    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node tmp, E e){
        if (tmp == null){
            ++size;
            return new Node(e);
        }
        if (e.compareTo(tmp.e) < 0){
            tmp.left = add(tmp.left, e);
        }
        else if (e.compareTo(tmp.e) > 0){
            tmp.right = add(tmp.right, e);
        }
        return tmp;
    }

    public boolean exist(E e){
        return exist(root, e);
    }

    private boolean exist(Node tmp, E e){
        if (tmp == null){
            return false;
        }
        if (e.equals(tmp.e)){
            return true;
        }
        else if (e.compareTo(tmp.e) < 0){
            return exist(tmp.left, e);
        }
        else if (e.compareTo(tmp.e) > 0){
            return exist(tmp.right, e);
        }
    }

}
