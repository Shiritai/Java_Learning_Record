import java.util.TreeMap;

public class HashTable<K, V> implements Map<K, V>{
    private static final int upperTol = 10; // 最大容忍上界
    private static final int lowerTol = 2; // 最小容忍上界
    private static final int initCapacity = 7;
    
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
        this(initCapacity); // 暫時先給一個固定值, 之後再優化改進
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
            h.put(key, value);
            /* 判斷是否擴容 */
            if (size >= upperTol * M){ // 原本條件應為 size / M >= upperTol, 在此避免使用除法而改寫如此
                resize(2 * M);
            }
        }
        else {
            h.put(key, value);
        }
    }
    
    @Override
    public V remove(K key){
        var h = table[hash(key)];
        if (h.containsKey(key)){
            --size;
            var ret = h.remove(key);
            /* 判斷是否擴容 */
            if (size < lowerTol * M && M / 2 >= initCapacity){ // 原本條件應為 size / M >= upperTol, 在此避免使用除法而改寫如此
                resize(M / 2);
            }
            return ret;
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

    private void resize(int newM){
        var newTable = new TreeMap[newM];
        for (int i = 0; i < newM; ++i){
            newTable[i] = new TreeMap<>();
        }
        /* 取出舊 hash table 所有元素, 重新加入 new hash table */
        int motoM = M; // 保留舊的 prime 以供遍歷
        this.M = newM; // 如此一來 hash prime 才會使用新 table 的 prime
        for (int i = 0; i < motoM; ++i){
            var tmp = table[i];
            for (var k : tmp.keySet()){
                newTable[hash(k)].put(k, tmp.get(k));
            }
            // tmp.keySet().forEach(k -> newTable[hash(k)].put(k, tmp.get(k)));
        }
        table = newTable;
    }
}
