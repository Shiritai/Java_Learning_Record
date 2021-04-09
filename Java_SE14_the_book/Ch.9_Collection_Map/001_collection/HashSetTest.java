import java.util.*;

class Student {
    private String name;
    private String ID;
    private int hiddenCode;
    Student(String name, String ID, int num){
        this.name = name;
        this.ID = ID;
        this.hiddenCode = num;
    }
    @Override
    public String toString(){
        return "Name : " + this.name + ", ID : " + this.ID + ", Code : " + this.hiddenCode;
    }
    
    @Override
    public int hashCode(){
        final int prime = 53;
        int result = prime * 1 + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((ID == null) ? 0 : ID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o){
        /* 確認兩物件的存在性 */
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        /* 確認兩物件相等 */
        Student other = (Student) o;
        if (name == null && other.name != null)
            return false;
        else if (!name.equals(other.name))
            return false;
        if (ID == null && other.ID != null)
            return false;
        else if (!ID.equals(other.ID))
            return false;
        return true;
    }
}
public class HashSetTest {
    public static void main(String [] args){
        var students = new HashSet<Student>();
        students.add(new Student("Eroiko", "000", 1));
        /* since this is the same object judged by "equals" we've written, the data won't refresh */
        students.add(new Student("Eroiko", "000", 2)); 
        students.add(new Student("Senjyougahara", "001", 1));
        students.add(new Student("Hanekawa", "002", 1));
        students.add(new Student("Eroiko", "003", 1)); // this is a new data judged by "equals"
        for (var i : students){
            System.out.println(i);
        }
    }
}
