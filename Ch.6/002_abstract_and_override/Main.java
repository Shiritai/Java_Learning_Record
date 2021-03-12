import static java.lang.System.*;

public class Main {
    public static void main(String[] args){

        var SomeMagician = new Magician();
        SomeMagician.setMagicPower(0x7fffffff);

        var Index = new Magician(10000, 100, "Index-Librorum-Prohibitorum");
        Index.setNickName("Hard Disk");
        
        var Misaka = new Nouryokusya(5, 300, "Misaka Mikoto");
        Misaka.setNickName("RailGun");
        
        var Uiharu = new Nouryokusya(1, 100, "Uiharu Kazari");
        
        var SomeNou = new Nouryokusya();
        Misaka.setNickName("Lv.5 Urban Legend");
        
        out.println(SomeMagician.dataString());
        out.println();
        out.println(Index.dataString());
        out.println();
        out.println(Misaka.dataString());
        out.println();
        out.println(Uiharu.dataString());
        out.println();
        out.println(SomeNou.dataString()); // notice the default value of the level
    }
}