import java.util.Stack;
import java.util.Queue; // this a actually a interface, 我們要給一個底層的資料結構
import java.util.LinkedList;

public class BST<E extends Comparable<E>> { // 注意這裡的寫法...

    // BST (i.e. 排序樹) 需要元素具有可比較性
    // 本 BST 不重複儲存大小相同的元素 -> 可透過 1. 修改比較邏輯 2. 增加「個數」成員在 Node 裡
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
        else {//e.compareTo(tmp.e) > 0
            return exist(tmp.right, e);
        }
    }

    public void preOrderNonRecur(){
        preOrderNonRecur(root);
    }

    public void preOrderNonRecur(Node tmp){
        var stack = new Stack<Node>();
        stack.push(tmp);
        while (!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node tmp){
        if (tmp != null){
            System.out.println(tmp.e);
            preOrder(tmp.left);
            preOrder(tmp.right);
        }
    }
    
    public void inOrder(){
        inOrder(root);
    }
    
    /* 正是「排序」的結果 */
    private void inOrder(Node tmp){
        if (tmp != null){
            preOrder(tmp.left);
            System.out.println(tmp.e);
            preOrder(tmp.right);
        }
    }

    public void posOrder(){
        posOrder(root);
    }
    
    /* 子樹先訪問 -> 可用於釋放記憶體 */
    private void posOrder(Node tmp){
        if (tmp != null){
            preOrder(tmp.left);
            preOrder(tmp.right);
            System.out.println(tmp.e);
        }
    }

    /* 廣度優先遍歷 */
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    @Override 
    public String toString(){
        var text = new StringBuilder();
        genPreOrderStr(root, 0, text);
        return text.toString();
    }

    private void genPreOrderStr(Node tmp, int depth, StringBuilder txt){
        for (int i = 0; i < depth; ++i){
            txt.append("<---->");
        }
        if (tmp == null){
            txt.append("null\n");
        }
        else {
            txt.append(tmp.e).append("\n");
            genPreOrderStr(tmp.left, depth + 1, txt);
            genPreOrderStr(tmp.right, depth + 1, txt);
        }
        return;
    }

}
