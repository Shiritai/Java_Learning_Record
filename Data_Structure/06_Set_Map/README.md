# Set

## 實現內容

```Java
Set<E>
void add(E e) // 不添加重複元素, e.g. 客戶統計、Anki 字詞統計
void remove(E e)
boolean exist(E e)
int getSize()
boolean isEmpty()
```

### 順序性

#### 有序 -> 常以搜索樹實現

#### 無序 -> 常以哈希表實現

# Map

映射，又可以形象化的稱作 dictionary, Python 正是如此

## 實現內容

```java
Map<K, V>
void add(K k, V v);
V remove(K k);
boolean exist(K k);
V get(K k);
void change(K k, V v);
int getSize();
boolean isEmpty();
```

### 順序性

#### 有序 -> 常以搜索樹實現

#### 無序 -> 常以哈希表實現


# The relationship between Set and Map

可以互相實現...

Set -> rewrite element to a pair of data (K, V), define "comparison" only relevant to K -> map

map -> V == null -> set