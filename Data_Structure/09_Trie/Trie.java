import java.util.TreeMap;

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
        if (!cur.isWord){ // WHY???
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
}
