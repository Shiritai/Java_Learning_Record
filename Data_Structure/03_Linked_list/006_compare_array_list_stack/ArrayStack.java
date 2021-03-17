public class ArrayStack<E> implements Stack<E>{ // 注意泛型使用
    Array<E> array;

    public ArrayStack(int capacity){
        array = new Array<E>(capacity);
    }

    public ArrayStack(){
        array = new Array<E>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){ // 因為是以陣列實現，因此有此函數
        return array.getCapacity();
    }

    @Override
    public void push(E e){
        array.insertBack(e);
    }

    @Override
    public E pop(){
        return array.deleteBack();
    }

    @Override
    public E peek(){
        return array.getLastElement();
    }

    @Override
    public String toString(){
        var tmp = new StringBuilder("Stack :\n(bottom) [");
        for (int i = 0; i < array.getSize() - 1; ++i){
            tmp.append(array.getElement(i)).append(", ");
        }
        tmp.append(array.getElement(array.getSize() - 1)).append("] (top)");
        return tmp.toString();
    }
}
