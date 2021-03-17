public class CircularQueue <E> implements Queue <E>{
    private E[] data;
    private int front, back, size;

    public CircularQueue(int capacity){
        data = (E[]) new Object[capacity + 1]; // notice the volume
        front = 0;
        back = 0;
        size = 0;
    }

    public CircularQueue(){
        this(16);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty(){
        return front == back;
    }

    @Override
    public int getSize(){
        return size;
    }

    @Override
    public void enqueue(E e){
        if ((back + 1) % data.length == front){
            resize(getCapacity() * 2);
        }

        data[back] = e;
        back = (back + 1) % data.length;
        ++size;
    }

    @Override
    public E dequeue(){
        if (isEmpty()){
            throw new IllegalArgumentException("Can't dequeue from an empty queue!");
        }
        E deleted = data[front];
        data[front] = null; // not necessary
        front = (front + 1) % data.length;
        --size;

        if (size <= getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return deleted;
    }

    @Override
    public E getFront(){
        if (isEmpty()){
            throw new IllegalArgumentException("The queue is empty.");
        }
        return data[front];
    }

    private void resize(int newCapacity){
        var newData = (E[]) new Object[newCapacity + 1]; // notice the volume
        for (int i = 0; i < size; ++i){
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        back = size;
    }

    @Override
    public String toString(){
        StringBuilder text = new StringBuilder(String.format("Circular Queue : size = %d, capacity = %d\n(front)  [", size, getCapacity()));
        for (int i = 0; i < size; ++i){
            text.append(data[(i + front) % data.length]).append(", ");
        }
        text.deleteCharAt(text.length() - 1).deleteCharAt(text.length() - 1).append("]  (back)");
        return text.toString();
    }

}