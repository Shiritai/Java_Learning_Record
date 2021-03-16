public class Main_ {
    public static void main(String[] args){
        var tmp = new Array(10);
        for (int i = 0; i < 19; ++i){ // since our array is dynamic OwO
            tmp.insertBack(i / 3);
            // System.out.println(tmp);
        }

        System.out.println(tmp);
        tmp.insert(1000, 4);
        System.out.println(tmp);
        tmp.insert(999, 4, 6);
        System.out.println(tmp);
        tmp.insertFront(-1000);
        System.out.println(tmp);
        int deleted = tmp.findAndDelete(5);
        System.out.println(tmp);
        deleted += tmp.delete(2, 10);
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