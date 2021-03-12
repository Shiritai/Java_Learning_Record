public class Client {
    public static void main(String [] args){
        var list = new ArrayList();
        var constant = "I am Eroiko and I like Monogatari Series!";
        
        /* push */
        for (char tmpChar : constant.toCharArray()){
            list.pushItem(tmpChar);
        }
        System.out.println(list);
        
        /* compare */
        var list2 = new ArrayList();
        var constant2 = "!seireS iratagonoM ekil I dna okiorE ma I";
        for (char tmpChar : constant2.toCharArray()){
            list2.pushItem(tmpChar);
        }
        if (list.equals(list2)){
            System.out.println("They are exactly the same.");
        }
        else {
            System.out.println("They are different.");
        }

        /* pop */
        int len = list.getSize();
        for (int i = 0; i < len; ++i){
            System.out.printf("%s", list.popItem());
        }
        System.out.println();
    }
}
