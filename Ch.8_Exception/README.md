# Java 例外處理

## 例外繼承結構
    
    | java.lang.Throwable
        | Error
            | - VirtualMachineError
            | - AssertionError // 正是那個「斷言」，似C
            | - ThreadError
            | - ...
        | Exception
            | - ReflectiveOperationException
                | - ClassNotFoundException
                | - InstantiationException
                | - ...
            | - IOException
                | - FileNotFoundException
                | - ...
            | - InterruptedException
            | - ...
            | - RuntimeException // 這裡的例外大多數是設計者自己的鍋 (bug)
                | - ArithmeticException
                | - ClassCastException
                | - IndexOutOfBoundsException
                | - ...

## java.lang.Throwable

* 為**所有例外之父類別**，其有兩的子類別 : **Error** 以及 **Exception**

* Method : 取得錯誤訊息、Stack Trace (堆疊追蹤)、...


## Error

* 嚴重系統錯誤
* 發生當下大多只能撒手不管，待未來設法解決

## Exception

* 程式設計有誤，都建議以 Exception 與其子類別實現
* 例外中，除了 Error 以及 RuntimeException 外，都必須設計出 try-catch 或者 throws 來處理，否則編譯失敗
  * 因此 Exception 中所有除了 RuntimeException 外的例外都是 Checked Exception (受檢例外)，即受編譯器檢查的例外
  * RuntimeException 及其子類別都是 Unchecked Exception
  * 採用受檢例外正式 Java 的一大特色 (其他語言暫時沒有)

# 例外捕捉與拋出

## try - catch - finally

常用於設計者可以直接處理的情況，選擇捕捉例外，並嘗試解決。

```java
try {
    // something...
} catch (Exception1 | Exception2 | ... | ExceptionM ex){ // multi-catch, 注意多重捕捉的例外不可有繼承關係
    // do something while encounter Exception2
} catch (ExceptionM1 | ExceptionM2 | .. | ExceptionN ex){
    // do something while encounter Exceptions
    ex.printStackTrace() // trace exception message
} finally { // 遇到例外時，程式中斷，若有未關閉的資源以及想做個收尾的程式碼，須藉由 finally 來做完成
    /* *
     * finally 無論是否有例外都會執行
     * 即便 try, catch 裡有 return, 也會先執行 finally 再返回
     * */
}
```

## Try-with-resource (自動嘗試關閉資源) from JDK7

```java
try (/* 原本欲在 finally 關閉的資源 */) {
    ...
} // 可以不用 catch，也可以有
```

Well 這正是 Compiler Sugar...

```java
try {
    ...
} catch (Throwable localThrowable1){ // catch ALL exception, error
    localThrowable2 = localThrowable1;
    throw localThrowable1;
} finally {
    if (/* 原本欲在 finally 關閉的資源 != null */){
        if (localThrowable2 != null) { // 若有 catch 到其他例外
            try {
                /* 原本欲在 finally 關閉的資源 */
            } catch (Throwable x2) {
                localThrowable2.addSuppressed(x2);
            }
        } else {
            /* 原本欲在 finally 關閉的資源 */
        }
    }
}
```


## throws

若當前情況無法處理例外，或者相信客戶端有能力且願意處理例外時使用。分為：

1. 直接拋出 -> throw***s*** ...
2. 與 try-catch 搭配使用 -> throw ...


# 例外繼承操作

Java 受檢與非受檢例外的使用原則，避免需要針對各種方法層層 throw 訊息上去。 

## 自訂受檢例外

```java
public class CustomizedException extends Exception { // 自訂受檢例外
    ...
}
```

## 自訂非受檢例外

```java
public class CustomizedException extends RuntimeException { // 自訂非受檢例外
    ...
}
```

# assert

使用於：

1. 確保客戶呼叫 Method 前已經做好前置準備，以及 Method 承諾的即果
2. 確保某物件在某時間點的狀態
3. 取代註解

**斷言使用時不要執行主程式碼的內容**

```java
assert boolean_expr;
assert boolean_expr : detail_msg;
```