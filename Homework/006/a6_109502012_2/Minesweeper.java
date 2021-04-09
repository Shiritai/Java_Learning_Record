package a6_109502012_2;

import java.util.Scanner;
import static java.lang.System.*;
public class Minesweeper {
    public static void main(String [] args){
        final int maxLen = 102;
        var mine = new int [maxLen][maxLen];
        var console = new Scanner(in);
        int length = console.nextInt();
        for (int i = 0; i < length; ++i){
            var tmp = console.next().toCharArray();
            for (int j = 0; j < length; ++j){
                if (tmp[j] == '*')
                    mine[i + 1][j + 1] = -1;
            }
        }
        for (int i = 1; i <= length; ++i){
            for (int j = 1; j <= length; ++j){
                if (mine[i][j] != -1){
                    int numOfMine = 0;
                    for (int x = -1; x <= 1; ++x){
                        for (int y = -1; y <= 1; ++y){
                            if (mine[i + x][j + y] == -1)
                                ++numOfMine;
                        }
                    }
                    mine[i][j] = numOfMine;
                }
            }
        }
        for (int i = 1; i <= length; ++i){
            for (int j = 1; j <= length; ++j)
                out.printf("%c", (mine[i][j] == -1) ? '*' : (mine[i][j] + '0'));
            out.println();
        }   
        console.close();    
    }
}
