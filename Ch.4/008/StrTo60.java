public class StrTo60 {
    public static void main(String[] args){
        var str = new StringBuilder();
        for (int i = 1; i <= 60; ++i){
            if (i < 10)
                str.append("0").append(i).append(", ");
            else if (i % 10 == 0)
                str.append(i).append("\n");
            else 
                str.append(i).append(", ");
        }
        System.out.println(str.toString());
    }
}
