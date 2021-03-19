/* object, is-a, dynamic array */

/* class Array == class Array extend Object (java.lang.Object) */

import java.util.Arrays;

public class Array {
    /* *
     * 欲蒐集各種不同 class 的資料在一個陣列，
     * 使用 Object 作為對象即可，
     * 因為 任何類別 is a Object
     * */
    public static void main(String[] args){
        Object[] data = {"Eroiko", 0xffffffff, new Person(894, "Hatikuji Mayoi")}; // 0xffffffff will do auto-boxing
        System.out.println(((Person) data[2]).dataString());

        var roles = new Array(100);
        roles.popItem();
        roles.pushItem("Meow");
        System.out.println(roles.getItem(0));
        roles.pushItem("Eroiko");
        System.out.println(roles.popItem());
    }

    /* this is a Mixed dynamic array */
    private Object [] dataBase;
    private int size;

    public Array(int size){
        dataBase = new Object[size];
    }

    public Array(){
        this(8);
    }

    public void pushItem(Object o){
        if (size == dataBase.length){
            dataBase = Arrays.copyOf(dataBase, dataBase.length * 2);
        }
        dataBase[size++] = o;
    }

    public Object popItem(){
        if (size < 1 / 4 * dataBase.length && dataBase.length / 2 != 0){
            dataBase = Arrays.copyOf(dataBase, dataBase.length / 2);
        }
        if (size > 0)
            return dataBase[size-- - 1];
        else 
            return null;
    }

    public Object getItem(int index){
        return dataBase[index];
    }
    
    public int getSize(){
        return size;
    }

}
