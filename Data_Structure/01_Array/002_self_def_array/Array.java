public class Array {
    // Advantage of array
    // 1. quick search
    // 2. better use when index is meaningful

    // Goal : complete "add", "delete", "change" and "search"
    private int [] data;
    private int size;
    
    /* constructor, input the capacity of the array */
    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }
    /* default capacity */
    public Array() {
        this(10);
    }

    public void addLast(int e){
        // if (size == data.length){
        //     throw new IllegalArgumentException("Append fail, the array is already full");
        // }
        // data[size++] = e;
        /* since we've complete the insert() func... */
        insert(size, e);
    }

    public void  addFirst(int e){
        insert(0, e);
    }

    // insert element e to the position pos
    public void insert(int pos, int e){
        if (size == data.length){
            throw new IllegalArgumentException("Append fail, the array is already full");
        }
        if (pos < 0 && pos > size){
            throw new IllegalArgumentException("The index is illegal");
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

    public int getElement(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("getElement failed, Index illegal");
        }
        return data[index];
    }
    
    public void overWrite(int index, int e){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("overWrite failed, Index illegal");
        }
        data[index] = e;
    }
    
    public int findIndex(int e){
        for (int i = 0; i < size; ++i){
            if (data[i] == e){
                return i;
            }
        }
        return -1;
    }
    // delete element at Index index and return the deleted value
    public int delete(int index){
        if (index < 0 || index >= size){
            throw new IllegalArgumentException("delete failed, Index illegal");
        }
        int tmp = data[index];
        for (int i = index; i < size; ++i){
            data[i] = data[i + 1];
        }
        --size;
        return tmp;
    }

    public int deleteFirst(){
        return delete(0);
    }

    public int deleteLast(){
        return delete(size - 1);
    }

    public void findAndDelete(int e){
        int ind = findIndex(e);
        if (ind != -1){
            delete(ind);
        }
        else {
            throw new IllegalArgumentException("element does not exist");
        }
    }

    public int findAndDeleteAll(int e){
        int numDel = 0;
        for (int i = 0; i < size; ++i){
            if (data[i] == e){
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
}
