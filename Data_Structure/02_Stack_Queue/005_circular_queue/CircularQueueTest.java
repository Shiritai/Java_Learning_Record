public class CircularQueueTest {
    public static void main(String[] args){
        /* test circular queue */
        var queue = new CircularQueue<Integer>();
        for(int i = 0 ; i < 24 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 4 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
