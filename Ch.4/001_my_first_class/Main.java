/* My first class OwO */
class Person { // notice that "object" (物件) is just the same meaning as "instance" (實例)
    /* fundamental "class" is just like the "structure" in C/C++ */
    String name, work;
    int age, height, weight;
    /* but we need this trivial statement to directly assign value */
    /* which is called "Constructor" */
    Person(String name, String work, int age, int height, int weight){
        this.name = name;
        this.work = work;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }
}

public class Main {
    public static void main(String[] args){
        // var Eroiko = new Person();
        // Eroiko.name = "Eroiko";

        /* after we add the "Constructor" to the class, we need to initialize "all" the value */
        var Senjyougahara = new Person("Senjyougahara", "undergraduate", 20, 172, 5);
    
        System.out.printf("%s\n", Senjyougahara.name);
    }
}
