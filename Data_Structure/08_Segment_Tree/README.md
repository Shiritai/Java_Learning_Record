# 線段樹 (Segment Tree)

## 使用場景與比較

在給定**區間**的更新 (一個或多個) 與查詢 (Max, Min, Segment), 而不考慮「添加、刪除」元素

-|Array|Segment Tree
:-:|:-:|:-:
更新|$O(n)$|$O(log(n))$
查詢|$O(n)$|$O(log(n))$

## Properties of Segment Tree

1. 非完全二叉樹
2. 是平衡二叉樹 (葉節點之間高度差不大於一)
3. 可以用靜態資結實現 (最後一層會有不少浪費的空間)
4. 可以用動態節點實現 (避免空間浪費)