interface Action {
    void execute(); // public abstract void execute() 
}

class Tmp implements Action {
    /* *
     * The visibility of execute() is lower than that in the original interface
     * public -> (no_claim)
     * */
    void execute(){
        System.out.println("Meow");
    }
}

public class Error {
    public static void main(String [] args){
        Action tmpAct = new Tmp();
        action.execute();
    }
}
