public interface Map<K, V> {
    void add(K key, V value);
    V remove(K key);
    boolean exist(K key);
    V get(K key);
    void change(K key, V value);
    int getSize();
    boolean isEmpty();
}
