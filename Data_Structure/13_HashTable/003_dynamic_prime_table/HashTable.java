import java.util.TreeMap;

public class HashTable<K, V> implements Map<K, V>{
    private final int [] capacityTable = {
        53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
        49157, 98317, 196613, 393241, 786433, 1572869, 3145739,
        6291469, 12582917, 25165843, 50331653, 100663319,
        201326611, 402653189, 805306457, 1610612741
    };

    private static final int upperTol = 10; // 最大容忍上界
    private static final int lowerTol = 2; // 最小容忍上界
    private int capInd = 0;
    
    private TreeMap<K, V> [] table;
    private int M; // 哈希表總體數量
    private int size; // 當前哈希表大小

    public HashTable(){
        this.M = capacityTable[capInd];
        this.size = 0;
        table = new TreeMap[M];
        for (int i = 0; i < M; ++i){
            table[i] = new TreeMap<>();
        }
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
            if (size >= upperTol * M && capInd < capacityTable.length - 1){
                resize(capacityTable[++capInd]);
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
            if (size < lowerTol * M && capInd >= 1){ // 原本條件應為 size / M >= upperTol, 在此避免使用除法而改寫如此
                resize(capacityTable[--capInd]);
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
