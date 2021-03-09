import static java.lang.System.*;


public class EightQueens {
    static int [] queens = new int[8];
    static final int maxQueen = 8;

    static int sumOfPossibilities = 0;

    static void placeQueen(int numOfQueens){
        if (numOfQueens == maxQueen){
            /* well, you can print this, but there are 40320 ways... */
            // out.println("-------------------");
            // for (int i = 0; i < maxQueen; ++i){
            //     out.printf("|");
            //     for (int j = 0; j < maxQueen; ++j){
            //         if (j == queens[i]){
            //             out.printf(" Q");
            //         }
            //         else{
            //             out.printf(" .");
            //         }
            //     }
            //     out.printf(" |\n");
            // }
            // out.println("-------------------\n");
            ++sumOfPossibilities;
            return;
        }
        else {
            /* Check placement */
            int placeCheck = 0;
            int tmp;
            for (int i = 0; i < numOfQueens; ++i){
                tmp = (1 << queens[i]);
                if ((tmp & placeCheck) == 1){
                    return;
                }
                placeCheck |= tmp;
            }
            /* place Queen */
            for (int i = 0; i < maxQueen; ++i){
                if ((placeCheck & (1 << i)) == 0){
                    queens[numOfQueens] = i;
                    placeQueen(numOfQueens + 1);
                }
            }
        }
        return;
    }
    
    public static void main(String[] args){
        placeQueen(0);
        out.println(sumOfPossibilities); // there are 40320 (i.e. 8!) possible ways to place Queens OwO
    }
}
