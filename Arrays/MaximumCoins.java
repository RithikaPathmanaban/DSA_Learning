// 4 
// 1 7 3 10
// 2 1 4 1
// 3 2 5 7
// 1 1 1 21



// 01 09 12 23 
// 02 04 13 14 
// 03 05 10 20 
// 01 04 06 31

// MaxVal = 31



import java.util.*;
public class MaximumCoins
{
    public static int find_max(int N, int[][] gold,int col,int row)
    {
        int num1 = 0;
        int num3 = 0;
        int num2 = 0;
        if(col-1 >= 0)
            num1 = gold[col-1][row-1];
        num2 = gold[col][row-1];
        if(col+1 < N)
            num3 = gold[col+1][row-1]; 
        return Math.max(Math.max(num1,num2) , num3);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[][] gold = new int[N][N];
        for(int row = 0 ; row < N ; row++)
            for(int col = 0 ; col < N ; col++)
                gold[row][col] = input.nextInt();
        for(int row = 1 ; row < N ; row++)
        {
            for(int col = 0 ; col < N ; col++)
            {
                gold[col][row]+=find_max(N,gold,col,row);
            }
        }
        int max = 0;
        for(int ind = 0 ; ind < N ; ind++)
        {
            max = Math.max(max,gold[ind][N-1]);
        }
        System.out.println(max);
        input.close();
    }
}








