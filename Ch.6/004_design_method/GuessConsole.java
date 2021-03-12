import java.util.Scanner;

public class GuessConsole extends Guess {
    private Scanner console = new Scanner(System.in);
    
    @Override
    public void print(String str){
        System.out.println(str);
    }
    
    @Override
    public int intReceive(){
        return console.nextInt();
    }
}
