import static java.lang.System.*;

public class Main {
    public static void main(String[] args){

        var SomeMagician = new Magician();
        var Index = new Magician(10000, 100, "Index-Librorum-Prohibitorum");
        Index.setNickName("Hard Disk");
        
        var Misaka = new Nouryokusya(5, 300, "Misaka Mikoto");
        Misaka.setNickName("RailGun");
        var Uiharu = new Nouryokusya(1, 100, "Uiharu Kazari");
        var SomeNou = new Nouryokusya();
        
        demoMagician(SomeMagician, Index);
        demoNouryokusya(SomeNou, Misaka, Uiharu);
        
        /* *
         * "Is a" relationship
         * since "Nouryokusya" (child class) is a "Person" (Parent Class)
         * the code below can run properly
         * */
        Person Kuroko = new Nouryokusya(4, 120, "Sirai Kuroko");
        /* *
         * The code below can also run properly 
         * since Saten can "Play" as a Nouryokusya 
         * because of the code above 
         */
        Nouryokusya Eroiko = (Nouryokusya) Kuroko;

        Person Saten = new Person(120, "Saten Ruiko");
        Saten.setNickName("Lv.5 Urban Legend");
        /* *
         * The code below won't run properly and 
         * "java.lang.ClassCastException" will rise up during runtime 
         * */
        Nouryokusya Elilokon = (Nouryokusya) Saten; // bad cast
        /* 
         * Of course the code below won't pass the compiler...
         * "incompatible types" will rise up
         * */
        Nouryokusya Elilokon2 = (Nouryokusya) Index;

        /* *
         * Since Index, Misaka, Saten are all "Person"
         * the code below can run properly!
         * */
        showNickname(Index);
        showNickname(Misaka);
        showNickname(Saten);

    }
    static void demoMagician(Magician A, Magician B){

        out.printf("%s\n\n", A.getName());
        out.printf("%s\nmagic power : %d, blood : %d\n\n", B.getName(), B.getMagicPower(), B.getBlood());
    }
    static void demoNouryokusya(Nouryokusya A, Nouryokusya B, Nouryokusya C){
        
        out.printf("%s\n\n", A.getName());
        out.printf("%s\nblood : %d, Lv.%d\n\n", B.getName(), B.getBlood(), B.getLevel());
        out.printf("%s\nblood : %d, Lv.%d\n\n", C.getName(), C.getBlood(), C.getLevel());

    }
    static void showNickname(Person role){
        out.printf("%s, also called \"%s\"\n", role.getName(), role.getNickName());
    }
}