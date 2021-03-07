public class Main {
    public static void main(String[] args){
        var tmp = new Array<Integer>(20);
        // Array<Integer> tmp = new Array<>(20); // also...
        for (int i = 0; i < 14; ++i){
            tmp.addLast(i / 3);
        }
        tmp.insert(4, 1000);
        tmp.addFirst(-1000);
        int deleted = tmp.findAndDeleteAll(0);

        System.out.println(tmp);
        System.out.println(deleted);
    }
}
