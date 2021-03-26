# Linked List

## Property

1. Real Dynamic data structure (we use "resize" to "Dynamic" change size, while the "array" itself is still static)
2. The simplest dynamic data structure
3. Enhance the comprehension of pointer (reference)
4. Enhance the comprehension of Recursion
5. Just like Array, this data structure can do help with other data structures

* Pros : no need to deal with the problem that comes from handling static volume
* Cons : can't access dynamically -> 不適合索引有意義的情況 (Array 反之)

## Complexity Analyzation

### insertion -> $O(n)$

* insertFirst(e) -> $O(1)$
* insertBack(e) -> $O(n)$
* insert(e, position) -> $O(n)$

### delete -> $O(n)$

* insertFirst(e) -> $O(1)$
* insertBack(e) -> $O(n)$
* insert(e, position) -> $O(n)$

### replace -> $O(n)$

### search -> $O(n)$

* getElement(position) -> $O(n)$
* exist(e) -> $O(n)$

### 注意只對「頭」進行的操作都只要 $O(1)$ (Stack OwO!)

## 更多鏈結序列

### 雙向鏈結序列

-> 有指向上一個以及下一個節點的指標

### 循環鏈結序列

-> 用一個 DummyHead 作為序列的頭與尾，成為一個環，每個一般節點皆為雙向訪問，Java Linked List 底層正是這個

### 陣列鏈結序列

-> 指標指向下一個節點在陣列裡的位置索引，這個在明確知道元素個數時還不錯用

[Linked List Problems](LinkedListProblems.pdf)