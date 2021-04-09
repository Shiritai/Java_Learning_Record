// package p6_109502012;
import static java.lang.System.*;
import java.util.*;

class LinkedList<E> {

    private final String doOutOfRangeMsg = "You're assigning a book with bad index, we can still do this to the last position.\nAre you sure you want to do it?";
    private final String confirmMsg = " [Y (y) / N (n)]";
    Scanner console = new Scanner(in);

    protected class Node {
        E e;
        Node next;
        Node(E e, Node next){
            this.e = e;
            this.next = next;
        }
        Node(E e){
            this(e, null);
        }
        Node(){
            this(null, null);
        }
    }
    
    private Node dummyHead;
    private int size;
    
    public LinkedList(){
        this.dummyHead = new Node();
        this.size = 0;
    }

    public boolean isEmpty(){ return size == 0;}
    
    public int getSize(){ return size;}
    
    public void add(E e, int position){
        --position;
        if (position > size || position < 0){
            out.println(doOutOfRangeMsg + confirmMsg);
            var tmp = console.next();
            if (tmp.equals("Y") || tmp.equals("y")){
                position = this.size;
            }
            else {
                return;
            }
        }
        var tmpNode = dummyHead;
        while (position > 0 && tmpNode != null){
            tmpNode = tmpNode.next;
            --position;
        }
        tmpNode.next = new Node(e, tmpNode.next);
        ++size;
    }
    
    public E delete(int position){
        --position;
        if (size == 0){
            out.println("There is no data yet.");
            return null;
        }
        if (position > size || position < 0){
            out.println(doOutOfRangeMsg + confirmMsg);
            var tmp = console.next();
            if (tmp.equals("Y") || tmp.equals("y")){
                position = this.size;
            }
            else {
                return null;
            }
        }
        var tmpNode = dummyHead;
        while (position > 0){ // delete : tmpNode.next
            tmpNode = tmpNode.next;
            --position;
        }
        var deletedNode = tmpNode.next;
        tmpNode.next = deletedNode.next;
        deletedNode.next = null;
        --size;
        return deletedNode.e;
    }

    @Override
    public String toString(){
        var content = new StringBuilder();
        content.append("[");
        var tmpNode = dummyHead.next;
        int tmpSize = size;
        if (tmpSize > 0){
            while (tmpSize > 1){
                content.append(tmpNode.e).append(", ");
                tmpNode = tmpNode.next;  
                --tmpSize;
            }
            content.append(tmpNode.e);
        }
        return content.append("]").toString();
    }
}
public class Bookshelf<E> {
    public static void main(String [] args){
        var bookShelf = new LinkedList<String>();
        var console = new Scanner(in);
        String tmpInput = console.nextLine();
        int cmd, parameter;
        String context;
        while (!tmpInput.equals("exit")){
            if (tmpInput.length() == 0){
                throw new IllegalArgumentException("No input data!");
            }
            var tmpOrder = tmpInput.split(" ");
            cmd = Integer.parseInt(getString(tmpOrder, 0));
            if (cmd == 0){ // for debugging and peeking
                out.println(bookShelf.toString());
                tmpInput = console.nextLine();
                continue;
            }
            if (cmd == 1){
                parameter = Integer.parseInt(getString(tmpOrder, 1));
                context = getString(tmpOrder, 2);
                bookShelf.add(context, parameter);
            }
            else if (cmd == 2){
                parameter = Integer.parseInt(getString(tmpOrder, 1));
                bookShelf.delete(parameter);
            }
            else {
                out.println("Undefined command, please try again.");
            }
            tmpInput = console.nextLine();
        }
        out.println(bookShelf.toString());
        console.close();
    }
    public static String getString(String [] tmpStr, int index){
        try {
            return tmpStr[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Not enough input data!");
        }
    }
}
