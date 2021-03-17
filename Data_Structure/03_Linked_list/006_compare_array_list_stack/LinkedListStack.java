public class LinkedListStack<E> implements Stack<E> {
    
    private LinkedList<E> list;

    public LinkedListStack(){
        list = new LinkedList<>();
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public void push(E e){
        list.insertFront(e);
    }

    @Override
    public E pop(){
        return list.deleteFront();
    }

    @Override
    public E peek(){
        return list.getFirstElement();
    }

    @Override
    public String toString(){
        var text = new StringBuilder("Stack : ");
        return text.append(list).toString();
    }
}
