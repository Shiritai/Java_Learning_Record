import static java.lang.System.*;

public class Senjyougahara implements Tsuntere, Yandere { // 可以一次實作多個介面
    public String name = "Senjyougahara";

    @Override
    public void tsuntere() {
        out.println("What I'm saying is not because of you, but I can take it if you don't come back.");
    }
    
    @Override
    public void yandere(){
        out.println("Show staples within a second and say : \"War start!\"");
    }

}
