import java.util.Arrays; // copyOf

public class Main {
    public static void main(String[] args){
        /* Array copy method */
        
        // notice that once the array is built, the length of the array cannot be changed
        Data [] data = {new Data("Eroiko", 98), new Data("Senjyougahara", 99), new Data("Hanekawa", 100)}; 
        
        /* Copy methods */
        data[0].grade = 97; // notice the change
        
        /* Shallow copy : only assign the reference, rather than create a new array */
        
        // method 1 : System.arraycopy(sourceArray, sourceStartIndex, target, targetStartIndex, copyLength)
        int copyLength = data.length; // can freely change
        
        Data [] shallowSysCopy = new Data[copyLength];
        System.arraycopy(data, 0, shallowSysCopy, 0, copyLength);
        
        data[0].grade = 88; // notice the change
        
        for (var i : shallowSysCopy){
            System.out.printf("%s : %d\n", i.name, i.grade);
        }
        System.out.println();
        
        // method 2 : Arrays.copyOf(sourceArray, copyLength) will return the whole array
        Data [] shallowArrayCopy = Arrays.copyOf(data, data.length);

        data[0].grade = 77; // notice the change
        
        for (var i : shallowArrayCopy){
            System.out.printf("%s : %d\n", i.name, i.grade);
        }
        System.out.println();

        
        // method 3 : assign the array use "="
        var shallowDirCopy = new Data[data.length]; // of course we can use "var"
        for (var i = 0; i < data.length; ++i){
            shallowDirCopy[i] = data[i];
        }

        data[0].grade = 66; // notice the change
        
        for (var i : shallowDirCopy){
            System.out.printf("%s : %d\n", i.name, i.grade);
        }
        System.out.println();
        
        /* Deep copy : create a new Array and assign values */
        var deepCopy = new Data[data.length];
        for (var i = 0; i < copyLength; ++i){
            deepCopy[i] = new Data(data[i].name, data[i].grade);
        }
        
        data[0].grade = 55; // now this won't effect to the new array deepCopy, i.e. I won't be flunked
        
        for (var i : deepCopy){
            System.out.printf("%s : %d\n", i.name, i.grade);
        }
        System.out.println();
    }
}
