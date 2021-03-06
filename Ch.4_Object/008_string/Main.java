public class Main {
    public static void main(String[] args){
        /* String, the object */
        var name = "Nadeko";
        // to char-array method
        char [] nameArray = name.toCharArray(); // like C++, both char array and string exist

        // "+" will generate a "new" String
        var tmpMessage = name + " is my waifu";
        /* 
         * more of "+" :
         * the former code will become...
         * --> String tmpMessage = (new StringBuilder()).append(name).append(" is my waifu").toString()
         */
        System.out.printf("%s\n\n", tmpMessage);

        /* 
         * String Parse method
         * size_t varName = TypeContainer.parserType(stringVar)
         * if can't parse properly, "NumberFormatException" will popped up
         */
        String num = "127";
        var strToByte = Byte.parseByte(num);
        var strToShort = Short.parseShort(num);
        var strToInt = Integer.parseInt(num);
        var strToLong = Long.parseLong(num);
        String num_ = "3.1415926";
        var strToFloat = Float.parseFloat(num_);
        var strToDouble = Double.parseDouble(num_);
        System.out.printf("toByte : %b\ntoShort : %d\ntoInt : %d\ntoLong : %d\ntoIFloat : %f\ntoDouble : %f\n\n", 
            strToByte, strToShort, strToInt, strToLong, strToFloat, strToDouble);

        /* String Pool */
        var waifuDeclare = "Nadeko is my waifu";
        System.out.printf("Is waifu declarations at the same position ? %b\n", tmpMessage == waifuDeclare);
        var tmp = "ja";
        var tmp0 = "ja" + "va";
        /* 
         * since "ja" and "va" are String literal (字串常量),
         * thus the compiler will replace this line with :
         * --> var tmp0 = "java"; 
         */
        var tmp1 = tmp + "va"; // while this still create a new string
        var tmp2 = "java";
        System.out.printf("tmp0 == tmp2 ? %b\ntmp1 = tmp2 ? %b\n", tmp0 == tmp2, tmp1 == tmp2);
    }
}
