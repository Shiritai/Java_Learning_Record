import static java.lang.System.out;

public class CallByValue {
    public static void main(String[] args){
        var tmp1 = new Person("Eroiko");
        changeValOfRef(tmp1);
        out.println(tmp1.name);
        var tmp2 = new Person("Eroiko");
        changeRefOfRef(tmp2);
        out.println(tmp2.name);
    }
    static void changeValOfRef(Person p){
        p.name = "Senjyougahara";
    }
    static void changeRefOfRef(Person p){
        p = new Person("Sasya"); // no effect to tmp2.name since the "new Person" will die after this function ended
    }

}

class Person {
    String name;
    Person (String name){
        this.name = name;
    }
}