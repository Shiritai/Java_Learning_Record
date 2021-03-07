public class Main {
    public static void main(String[] args){
        var tmp = new Array(20);
        for (int i = 0; i < 19; ++i){ // since our array is dynamic OwO
            tmp.addLast(i / 3);
        }

        System.out.println(tmp);
        tmp.insert(4, 1000);
        System.out.println(tmp);
        tmp.addFirst(-1000);
        System.out.println(tmp);
        int deleted = tmp.findAndDelete(5);
        System.out.println(tmp);
        deleted += tmp.findAndDeleteAll(0);
        System.out.println(tmp);
        deleted += tmp.findAndDeleteAll(3);
        System.out.println(tmp);
        deleted += tmp.findAndDeleteAll(2);
        System.out.println(tmp);
        deleted += tmp.findAndDeleteAll(4);

        System.out.println(tmp);
        System.out.printf("Deleted %d elements from the beginning.\n", deleted);
    }
}