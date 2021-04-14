# Trie 字典樹

純粹為「字串查找」 (e.g. 字典) 服務的高效率資料結構

```java
class Node {
    // char c; // 其實可以不需要，因為 Map 的性質
    // Node next[]; // 不夠靈活，改用 Map
    boolean isWord; // 表示進行到此是一個單字，如 pan 跟 panda, 需在 n 標註 isWord
    Map<char, Node> next;
}
```
