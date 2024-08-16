import java.util.*;
public class Nqueens 
{
    static int cnt = 1;
    public static void display(int N,int[][] board)
    {
        System.out.printf("Solution no : %d\n",cnt++);
        for(int row = 0 ; row < N ; row++)
        {
            for(int col = 0 ; col < N ; col++)
            {
                System.out.printf("%c ",(board[row][col] == 0)?'-':'Q'); 
            }
            System.out.println();
        }
        System.out.println();
    }
    public static int isSafe(int N,int[][] board,int row,int col)
    {
        int temp_r = 0;
        int temp_c = 0;
        for(temp_r = row-1 ; temp_r >= 0 ; temp_r--)
            if(board[temp_r][col] == 1) return 0;
        for(temp_r = row-1,temp_c = col-1 ; temp_r >= 0 && temp_c >= 0 ; temp_r--,temp_c--)
            if(board[temp_r][temp_c] == 1) return 0;
        for(temp_r = row-1,temp_c = col+1 ; temp_r >= 0 && temp_c < N ; temp_r-- ,temp_c++)
            if(board[temp_r][temp_c] == 1) return 0;
        return 1;
    }
    public static void Solve(int N,int[][] board,int row)
    {
        if(row == N)
        {
            display(N,board);
        }
        else 
        {
            for(int col = 0 ; col < N ; col++)
            {
                if(isSafe(N,board,row,col) == 1)
                {
                    board[row][col] = 1;
                    Solve(N, board, row+1);
                    board[row][col] = 0;
                }
            }
        }
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] board = new int[N][N];
        Solve(N,board,0);
        input.close();
    }
}