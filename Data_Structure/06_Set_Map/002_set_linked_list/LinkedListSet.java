public class LinkedListSet<E> implements Set<E> {
    
    private LinkedList<E> list;

    public LinkedListSet(){
        list = new LinkedList<E>();
    }

    @Override
    public void add(E e){
        if (!list.exist(e))
            list.insertFront(e);
    }

    @Override
    public void remove(E e){
        list.deleteElement(e);
    }

    @Override
    public boolean exist(E e){
        return list.exist(e);
    }

    @Override
    public int getSize(){
        return list.getSize();
    }

    @Override
    public boolean isEmpty(){
        return list.isEmpty();
    }

}
