# Tree

動態、天然、無所不在、自帶遞迴結構、優化好幫手

## Binary Tree

...很熟悉ㄌ就不做筆記ㄅ

## Binary Search Tree

* 節點值大於左子樹所有值，小於右子樹所有值
* 儲存的元素必須有可比較性
* 不重複儲存同樣值得元素 (或者可透過 1.修改比較邏輯 2. 增加「個數」成員在 Node 裡)


### 深度優先遍歷 -> 用遞迴遍歷

前序、中序 (印出排序結果)、後續 (優先訪問子樹)

以上亦可用諸如 Stack 等資結輔助來遍歷

### 廣度優先遍歷 -> 用 Queue 輔助，迴圈遍歷

用來更快的尋找目標 -> Algorithm 的 Shortest Path

## Special terms about BST

1. 順序性
   1. maximum and minimum
   2. successor and predecessor
   3. floor (最小上界) and ceil (最大下界) 
      * 尋找 floor and ceil 不需要目標值真的存在在 BST 中
      * 如找 45 的 floor and ceil 可能為 41, 50 但不需要 45 存在在整個 BST 中
   4. rank (某 Node 在 BST 中的排行) and select (在 BST 中排行某某的 Node)
      * 維護所有子樹的 Size
      * 如葉子 Node : size = 1

2. 擴展
   1. size and depth for every Node
   2. 支持重複元素
      1. 新增節點時，要加在>= 與 <= 二選一
      2. 新增維護 count // 跟窩想ㄉ一樣 OwO
