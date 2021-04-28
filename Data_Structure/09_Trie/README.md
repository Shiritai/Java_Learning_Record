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

## 問題 : 空間消耗過大

解決方法

1. Compressed Trie : 將單鏈字符串何在一起存, 在加入新字需要時才可能擴展 -> 但維護成本增加
2. Ternary Search Trie : 三分搜索 Trie : 只有 3 個子樹, 犧牲一定時間

## 計算機科學中的字串話題

### 子串查詢 : 算法

1. KMP
2. Boyer-Moore
3. Rabin-Karp

### 文件壓縮

### 模式匹配 (Regex)

### 編譯原理 (語彙, 語法, 語意分析)

### DNA