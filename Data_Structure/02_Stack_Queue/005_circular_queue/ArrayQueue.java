public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }

    public ArrayQueue(){
        array = new Array<>();
    }

    @Override
    public int getSize(){
        return array.getSize();
    }

    @Override
    public boolean isEmpty(){
        return array.isEmpty();
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public void enqueue(E e){
        array.insertBack(e);
    }

    @Override
    public E dequeue(){
        return array.deleteFront();
    }

    @Override
    public E getFront(){
        return array.getFirstElement();
    }

    @Override 
    public String toString(){
        var tmp = new StringBuilder("Queue\n (front) [");
        for (int i = 0; i < array.getSize() - 1; ++i){
            tmp.append(array.getElement(i)).append(", ");
        }
        tmp.append(array.getElement(array.getSize() - 1)).append("] (back)");
        return tmp.toString();
    }
}
