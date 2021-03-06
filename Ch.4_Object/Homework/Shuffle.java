import java.util.Random; // for Random()
import java.util.Arrays; // for fill()

public class Shuffle {
    public static final int CARD_LENGTH = 52; // define a constant like "Marco var" in C/C++

    /* use Fisher–Yates shuffle algorithm */
    static void shuffle(int[] array) {
        int n = array.length;
        Random random = new Random();
        // Loop over array.
        for (int i = 0; i < array.length; i++) {
            // Get a random index of the array past the current index.
            // ... The argument is an exclusive bound.
            //     It will not go past the array's end.
            int randomValue = i + random.nextInt(n - i); // i <= randomValue < n
            // Swap the random element with the present element.
            int randomElement = array[randomValue];
            array[randomValue] = array[i];
            array[i] = randomElement;
        }
    }

    static void printCard(int card) {
        System.out.printf("{%d, %2d} ", card % 4, card / 4 + 1);
    }

    public static void main(String[] args) {
        int[] values = new int[CARD_LENGTH];
        for (int i = 1; i <= 52; ++i){
            values[i - 1] = i;
        }
        // Shuffle integer array.
        shuffle(values);
        // Display elements in array.
        for (int i = 0; i < CARD_LENGTH; ++i) {
            printCard(values[i]);
            if (i % 13 == 12){
                System.out.println();
            }
        }
    }
}
