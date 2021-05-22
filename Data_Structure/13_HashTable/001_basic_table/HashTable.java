import java.util.TreeMap;

public class HashTable<K, V> implements Map<K, V>{
    private TreeMap<K, V> [] table;
    private int M; // 哈希表總體數量
    private int size; // 當前哈希表大小

    public HashTable(int M){
        this.M = M;
        this.size = 0;
        table = new TreeMap[M];
        for (int i = 0; i < M; ++i){
            table[i] = new TreeMap<>();
        }
    }

    public HashTable(){
        this(97); // 暫時先給一個固定值, 之後再優化改進
    }
    
    private int hash(K key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    @Override
    public int getSize(){ return size; }
    @Override
    public boolean isEmpty(){ return size == 0; }

    @Override
    public void add(K key, V value){
        var h = table[hash(key)];
        if (!h.containsKey(key)){ // TreeMap's method
            ++size;
        }
        h.put(key, value); // 不管是添加還是更新資料，都使用 put(k, v)
    }

    @Override
    public V remove(K key){
        var h = table[hash(key)];
        if (h.containsKey(key)){
            --size;
            return h.remove(key);
        }
        return null;
    }

    @Override
    public void set(K key, V value){
        var h = table[hash(key)];
        if (!h.containsKey(key)){
            throw new IllegalArgumentException(key + " does not exist!");
        }
        h.put(key, value);
    }

    @Override
    public boolean exist(K key){
        return table[hash(key)].containsKey(key);
    }

    @Override
    public V get(K key){
        return table[hash(key)].get(key);
    }
}
