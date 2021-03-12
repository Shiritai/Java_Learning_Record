/* Template method */

public abstract class Guess {
    public void play(){
        var ans = (int) (Math.random() * 10);
        int guess;
        do {
            print("Enter a number...");
            guess = intReceive();
        } while (guess != ans);
        print("Hit! Congratulations");
    }
    public abstract void print(String str);
    public abstract int intReceive();
}
