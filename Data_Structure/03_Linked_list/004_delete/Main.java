public class Main {
    public static void main(String[] args){
        var data = new LinkedList<Integer>();
        for (int i = 0; i < 10; i += 2){
            data.insertFront(i); // O(1), notice that insertBack() is O(n)
            System.out.println(data);
        }
        
        data.insert(123, 4);
        System.out.println(data);
        
        data.delete(4);
        System.out.println(data);
        
        data.deleteFront();
        System.out.println(data);
        
        data.deleteBack();
        System.out.println(data);
    }
}
