import static java.lang.System.*;
import java.util.Scanner;

public class RatMaze {
    {
        out.println("Enter the initial position, start direction and end position");
    }

    static final int xLen = 7;
    static final int yLen = 7;
    static int endX;
    static int endY;

    static final int [][] maze = {
        {2, 2, 2, 2, 2, 2, 2},
        {0, 0, 0, 0, 0, 0, 2},
        {2, 0, 2, 2, 2, 0, 2},
        {2, 0, 0, 2, 0, 2, 2},
        {2, 2, 0, 2, 0, 2, 2},
        {2, 0, 0, 0, 0, 0, 2},
        {2, 2, 2, 2, 2, 0, 2},
    };

    /* *
     * direction number
     *   1
     * 4 0 2
     *   3
     */
    static boolean goRat(int x, int y, int dir){ // dir : coming direction
        if (x < 0 || x >= xLen || y < 0 || y >= yLen){
            return false;
        }
        else if (maze[y][x] == 2){
            return false;
        }
        else if (x == endX && y == endY){
            out.printf("Finished!\n(%d, %d)", x, y);
            return true;
        }
        else {
            boolean [] rec = {false, false, false, false};
            switch (dir){
                case 1: 
                rec[0] = goRat(x, y + 1, 1);
                rec[1] = goRat(x - 1, y, 2);
                rec[3] = goRat(x + 1, y, 4);
                break;

                case 2: 
                rec[0] = goRat(x, y + 1, 1);
                rec[1] = goRat(x - 1, y, 2);
                rec[2] = goRat(x, y - 1, 3);
                break;
                
                case 3: 
                rec[1] = goRat(x - 1, y, 2);
                rec[2] = goRat(x, y - 1, 3);
                rec[3] = goRat(x + 1, y, 4);
                break;
                
                case 4: 
                rec[0] = goRat(x, y + 1, 1);
                rec[2] = goRat(x, y - 1, 3);
                rec[3] = goRat(x + 1, y, 4);
                break;
            }

            for (var result : rec){
                if (result){
                    out.printf(" <-- (%d, %d)", x, y);
                    return true;
                }
            }

            return false;
        }
    }

    public static void main(String[] args){
        var console = new Scanner(in);

        out.printf("initial x position >>  ");
        int initX = console.nextInt();

        out.printf("initial y position >>  ");
        int initY = console.nextInt();

        out.printf("start direction >>  ");
        String startDir = console.next();

        out.printf("end x position >>  ");
        endX = console.nextInt();
        
        out.printf("end y position >>  ");
        endY = console.nextInt();

        int dir = 0;

        switch (startDir){
            case "North":
                dir = 3;
                break;
            case "East":
                dir = 4;
                break;
            case "South":
                dir = 1;
                break;
            case "West":
                dir = 2;
                break;
            default:{
                out.println("Please give us the start direction, such as North, South, East, West");
            }
        }

        var success = goRat(initX, initY, dir);
        if (!success){
            out.println("This is a dead maze!");
        }

        console.close();
    } 
}