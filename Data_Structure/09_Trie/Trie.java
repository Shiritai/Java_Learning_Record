import java.util.TreeMap;
import java.util.Stack;

public class Trie {
    private class Node {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord){
            this.isWord = isWord;
            this.next = new TreeMap<>();
        }
        public Node(){
            this(false);
        }
    }

    // private class tuple<K, V>{
    //     public final K key;
    //     public final V value;
    //     tuple(K key, V value){
    //         this.key = key;
    //         this.value = value;
    //     }
    // }
    
    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    /* get the number of vocabularies in the Trie */
    public int getSize(){ return size;}

    /* Add a new word into this Trie */
    public void add(String newWord){
        Node cur = root;
        for (var chr : newWord.toCharArray()){
            if (cur.next.get(chr) == null){
                cur.next.put(chr, new Node());
            }
            cur = cur.next.get(chr);
        }
        if (!cur.isWord){
            cur.isWord = true;
            ++size;
        }
    }
    
    public boolean contains(String word){
        Node cur = root;
        for (var chr : word.toCharArray()){
            if (cur.next.get(chr) == null){
                return false;
            }
            cur = cur.next.get(chr);
        }
        return cur.isWord;
    }

    /* 超級高的效率查詢前綴, 因此 Trie 又稱前綴樹 */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for (var chr : prefix.toCharArray()){
            if (cur.next.get(chr) == null){
                return false;
            }
            cur = cur.next.get(chr);
        }
        return true;
    }

    /* 嘗試刪除 word, 若 word 不存在返回 false, 存在返回 true */
    public boolean delete(String word){
        Node cur = root;
        var stack = new Stack<Node>();
        // boolean existOtherWord = false;
        for (var chr : word.toCharArray()){
            if (cur.next.get(chr) == null){
                return false; // 沒有此字
            }
            stack.push(cur);
            cur = cur.next.get(chr);
        }
        stack.push(cur);
        if (cur.isWord){
            cur.isWord = false;
            this.size--;
        }
        while (!stack.isEmpty()){
            cur = stack.pop();
            if (cur.next == null){
                cur = null;
            }
            else {
                break;
            }
        }
        return true;
    }
}
