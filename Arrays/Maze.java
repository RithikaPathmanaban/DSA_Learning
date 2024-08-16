//mooshak mouse mooshak the mouse has been placed in a maze.There is a huge chunk of cheese somewhere in the maze.
// the maze is represented as a two dimensional array of intgeres where 0 represents walls.1 represents paths where
//  mooshak can move ans 9 represents the huge chunk of cheese.Mooshal starts in the top left corner at 0.
// write a methosd in path of class maze oath to detremine if mooshak can reach the hige chucnk of cheese.the input to is path
// consists of a two dimensional array gnd for the maze matrix.the methos should return 1 if thereis a path from moochak to
//  the cheese and 0 if not mooshak is not allowed to leace the maze or climb on walls.

// Ex 8 by 8(8*8) matrix maze where mooshak can get the cheese
// 1 0 1 1 1 0 0 1
// 1 0 0 0 1 1 1 1
// 1 0 0 0 0 0 0 0
// 1 0 1 0 9 0 1 1
// 1 1 1 0 1 0 0 1
// 1 0 1 0 1 1 0 1
// 1 0 0 0 0 1 0 1
// 1 1 1 1 1 1 1 1


//approach 1
// import java.util.*;
// public class PSNA 
// {
//     static int found = 0;
//     public static void display(int N,int[][] maze)
//     {
//         for(int row = 0 ; row < N ; row++)
//         {
//             for(int col = 0 ; col < N ; col++)
//             {
//                 System.out.print(maze[row][col]+" ");
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }
//     public static boolean isSafe(int N,int[][] maze,int next_row,int next_col)
//     {
//         return next_row >= 0 && next_row < N && next_col >= 0 && next_col < N && maze[next_row][next_col]!=0 && maze[next_row][next_col]!=2;
//     }
//     public static void isPath(int N,int[][] maze,int row,int col)
//     {
//         int next_row = 0;
//         int next_col = 0;
//         if(maze[row][col] == 9)
//         {
//             display(N,maze);
//             found = 1;
//         }
//         else 
//         {
//             next_row = row;
//             next_col = col - 1;
//             if(isSafe(N,maze,next_row,next_col) == true)
//             {
//                 maze[row][col] = 2;
//                 isPath(N, maze, next_row, next_col);
//                 maze[row][col] = 1;
//             }
//             next_row = row - 1;
//             next_col = col;
//             if(isSafe(N,maze,next_row,next_col) == true)
//             {
//                 maze[row][col] = 2;
//                 isPath(N, maze, next_row, next_col);
//                 maze[row][col] = 1;
//             }
//             next_row = row;
//             next_col = col + 1;
//             if(isSafe(N,maze,next_row,next_col) == true)
//             {
//                 maze[row][col] = 2;
//                 isPath(N, maze, next_row, next_col);
//                 maze[row][col] = 1;
//             }
//             next_row = row + 1;
//             next_col = col;
//             if(isSafe(N,maze,next_row,next_col) == true)
//             {
//                 maze[row][col] = 2;
//                 isPath(N, maze, next_row, next_col);
//                 maze[row][col] = 1;
//             }
//         }
//     }
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         int N = input.nextInt();
//         int[][] maze = new int[N][N];
//         for(int row = 0 ; row < N ; row++)
//         {
//             for(int col = 0 ; col < N ; col++)
//             {
//                 maze[row][col] = input.nextInt();
//             }
//         }
//         System.out.println();
//         isPath(N,maze,0,0);
//         if(found == 0)
//             System.out.println("Solution Not Available");
//         input.close();
//     }
// }








//approach 2


// import java.util.*;
// public class Maze
// {
//     static int found = 0;
//     static int[] rref = {0,-1,0,1};
//     static int[] cref = {-1,0,1,0};
//     public static void display(int N,int[][] maze)
//     {
//         for(int row = 0 ; row < N ; row++)
//         {
//             for(int col = 0 ; col < N ; col++)
//             {
//                 System.out.print(maze[row][col]+" ");
//             }
//             System.out.println();
//         }
//         System.out.println();
//     }
//     public static boolean isSafe(int N,int[][] maze,int next_row,int next_col)
//     {
//         return next_row >= 0 && next_row < N && next_col >= 0 && next_col < N && maze[next_row][next_col]!=0 && maze[next_row][next_col]!=2;
//     }
//     public static void isPath(int N,int[][] maze,int row,int col)
//     {
//         int next_row = 0;
//         int next_col = 0;
//         if(maze[row][col] == 9)
//         {
//             display(N,maze);
//             found = 1;
//         }
//         else 
//         {
//             for(int ind = 0 ; ind < 4 ; ind++)
//             {
//                 next_row = row + rref[ind];
//                 next_col = col + cref[ind];
//                 if(isSafe(N,maze,next_row,next_col) == true)
//                 {
//                     maze[row][col] = 2;
//                     isPath(N, maze, next_row, next_col);
//                     maze[row][col] = 1;
//                 }
//             }
//         }
//     }
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         int N = input.nextInt();
//         int[][] maze = new int[N][N];
//         for(int row = 0 ; row < N ; row++)
//         {
//             for(int col = 0 ; col < N ; col++)
//             {
//                 maze[row][col] = input.nextInt();
//             }
//         }
//         System.out.println();
//         isPath(N,maze,0,0);
//         if(found == 0)
//             System.out.println("Solution Not Available");
//         input.close();
//     }
// }


//approach 3
import java.util.*;
public class Maze
{
    public static void display(int N,int[][] maze)
    {
        for(int row = 0 ; row < N ; row++)
        {
            for(int col = 0 ; col < N ; col++)
            {
                System.out.print(maze[row][col]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void isPath(int N,int[][] maze,int row,int col)
    {
        if(!(row >= 0 && row < N && col >= 0 && col < N && maze[row][col]!=0 && maze[row][col]!=2))
            return;
        if(maze[row][col] == 9)
        {
            display(N,maze);
        }
        maze[row][col] = 2;
        isPath(N, maze, row, col-1);
        isPath(N, maze, row-1, col);
        isPath(N, maze, row, col+1);
        isPath(N, maze, row+1, col);
        maze[row][col] = 1;
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] maze = new int[N][N];
        for(int row = 0 ; row < N ; row++)
        {
            for(int col = 0 ; col < N ; col++)
            {
                maze[row][col] = input.nextInt();
            }
        }
        System.out.println();
        isPath(N,maze,0,0);
        input.close();
    }
}


