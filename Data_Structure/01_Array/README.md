# Array
---

# Array 複雜度分析

;):):(;( // 太有趣了吧，markdown 語法

噢不... Github 不支持 LaTex 數學語法
<!-- 練習數學表達式 -->

## 插入元素 : $O(n)$


/|最後|最前|隨機
:-:|:-:|:-:|:-:
**對應實作**|addLast(e)|addFirst(e)|insert(index, e)
$BigO$|$O(1)$|$O(n)$|$O(n)(O(\frac n2))$



<!-- $$ f(x,y,z) = 3y^2z \left( 3+\frac{7x+5}{1+y^2} \right) $$ -->


## 刪除元素 : $O(n)$


/|最後|最前|隨機
:-:|:-:|:-:|:-:
**對應實作**|deleteFirst(e)|deleteLast(e)|delete(index, e)
$BigO$|$O(1)$|$O(n)$|$O(n)$


**resize(len)** : $O(n)$


## 修改元素 : $O(1)$
#### Array 的優勢：支持隨機訪問!

**overWrite(index, e)** : $O(1)$

## 查詢元素 $O(1)→O(n)$

/|已知索引|未知索引
:-:|:-:|:-:
**對應實作**|getElement(index)|findIndex(e)
$BigO$|$O(1)$|$O(n)$

# Amortized time complexity 均攤複雜度

## resize 複雜度分析

#### addLast

設 10 次 addLast 觸發 resize，共 10 次基本操作 + 10 次擴容操作

→ n 次 addLast 觸發 resize，共 n 次基本操作 + n 次擴容操作
因此複雜度應為 $O(\frac{2n}{n}) = O(1)$

#### deleteLast

同樣的，複雜度應為 $O(1)$

## 複雜度震盪

如在臨界長度連續進行擴容+降容，導致複雜度保持高點 $ = O(n)$

→ ***too EAGER*** → 採 ***LAZY*** 策略