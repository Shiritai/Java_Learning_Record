/* i.e. "Copy and Paste!" */
public class Array<T>{
    // Goal : complete "add", "delete", "change" and "search"
    private T [] data;
    private int size;
    
    /* constructor, input the capacity of the array */
    public Array(int capacity) {
        this.data = (T[]) new Object[capacity];
        this.size = 0;
    }
    /* default capacity */
    public Array() {
        this(10);
    }

    public void addLast(T e){
        insert(size, e);
    }

    public void  addFirst(T e){
        insert(0, e);
    }

    // insert element e to the position pos
    public void insert(int pos, T e){
        if (pos < 0 && pos > size){
            throw new IllegalArgumentException("The index is illegal");
        }
        /* resize! */
        if (size == data.length){
            resize(2 * data.length); // data.length size is related to the container of data structure
        }
        for (int i = size - 1; i >= pos; --i){
            data[i + 1] = data[i];
        }
        data[pos] = e;
        ++size;
        return;
    }

    @Override
    public String toString(){
        StringBuilder str = (new StringBuilder()).append(String.format("Array: size = %d, capacity = %d\n", size, data.length));
        str.append('[');
        for (int i = 0; i < size - 1; ++i){
            str.append(String.format("%d, ", data[i]));
        }
        str.append(String.format("%d]", data[size - 1]));
        return str.toString();
    }

    public T getElement(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("getElement failed, Index illegal");
        }
        return data[index];
    }
    
    public void overWrite(int index, T e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("overWrite failed, Index illegal");
        }
        data[index] = e;
    }
    
    public int findIndex(T e){
        for (int i = 0; i < size; ++i){
            if (data[i].equals(e)){
                return i;
            }
        }
        return -1;
    }
    // delete element at Index index and return the deleted value
    public T delete(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("delete failed, Index illegal");
        }
        T tmp = data[index];
        for (int i = index; i < size - 1; ++i){
            data[i] = data[i + 1];
        }
        --size;
        /* 
         * below is a loitering object, which is NOT memory leak!!!
         * since java won't remove it automatically
         */
        data[size] = null;

        if (size == data.length / 2){
            resize(data.length / 2);
        }

        return tmp;
    }

    public T deleteFirst(){
        return delete(0);
    }

    public T deleteLast(){
        return delete(size - 1);
    }

    public int findAndDelete(T e){
        int ind = findIndex(e);
        if (ind != -1){
            delete(ind);
            return 1;
        }
        else {
            // throw new IllegalArgumentException("element does not exist");
            return 0;
        }
    }

    public int findAndDeleteAll(T e){
        int numDel = 0;
        for (int i = 0; i < size; ++i){
            if (data[i].equals(e)){
                delete(i);
                --i; // move back a block
                ++numDel;
            }
        }
        return numDel;
    }

    public int getSize(){
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newCapacity) {
        T [] newData = (T []) new Object[newCapacity];
        for (int i = 0; i < size; ++i){
            newData[i] = data[i];
        }
        data = newData;
    }
}
