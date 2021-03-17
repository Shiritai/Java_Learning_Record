import static java.lang.System.out;

public class Anonymous {
    public Anonymous(){};
    
    public Anonymous(int Tmp){
        out.println("Int parameter");
    }

    public Anonymous(Integer Tmp){
        out.println("Float parameter");
    }
    
    public Anonymous(String Tmp){
        out.println("String parameter");
    }

    public Anonymous(float Tmp){
        out.println("Float parameter");
    }

    
    public static void main(String [] args){

        /* *
         * Anonymous inner class (匿名內部實例)
         * */
        Object o = new Object(){ // inherit "Object", redefine toString() and generate a instant directly
            @Override
            public String toString() {
                return "example\n";
            }
        };
        out.println(o);

        /* var + Object 的應用 */
        var varObjectList = new Object(){
            Object[] data = {"Ononogi Yotigi", (int) 1, (Integer) 2, 3f};

            void printData(){ // 內部匿名方法直接印出資料
                out.println("In tmp anonymous class...");
                for (var tmp : data){
                    out.println(String.format("%-23s -> %s", tmp.getClass(), tmp)); // %[-][num]s : - 表靠左對齊
                }
            }

            Object getName(){
                return data[0];
            }
        };

        out.println(varObjectList.getName());
        
        out.println();

        for (var tmp : varObjectList.data){ // 取用內部匿名方法的資料後印出
            out.println(tmp);
        }

        out.println();

        varObjectList.printData();

    }
}
