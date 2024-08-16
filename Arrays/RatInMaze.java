//Rat in a maze
import java.util.*;
public class RatInMaze 
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
    public static void Solve(int N,int[][] maze,int row,int col)
    {
        int next_row = 0;
        int next_col = 0;
        if(row == N-1 && col == N-1)
        {
            maze[row][col] = 1;
            display(N,maze);
            maze[row][col] = 0;
        }
        else 
        {
            next_row = row;
            next_col = col + 1;
            if(next_row >= 0 && next_row < N && next_col >= 0 && next_col < N) 
            {
                maze[row][col] = 1;
                Solve(N, maze, next_row, next_col);
                maze[row][col] = 0;
            }
            next_row = row + 1;
            next_col = col;
            if(next_row >= 0 && next_row < N && next_col >= 0 && next_col < N) 
            {
                maze[row][col] = 1;
                Solve(N, maze, next_row, next_col);
                maze[row][col] = 0;
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] maze = new int[N][N];
        Solve(N,maze,0,0);
        input.close();
    }
}


