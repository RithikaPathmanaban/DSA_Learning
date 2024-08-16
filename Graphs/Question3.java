// Question 3:
// You are given a maze with N cells. Each cell may have multiple entry points but no more than one exit (i.e. entry/exit points are unidirectional doors like valves). The cells are named with an integer value from 0 to N-1.

// You need to do the following:
// 1.	What is the maximum sum in the cycle/ path

// Input Format:
// •	First line has the number of cells N
// •	Second line has list of N values of the edge[] array. edge[i] contains the cell number that can be reached from cell “I” in one step. edge[i] is -1 if the cell does not have an exit.

// Output format:
// •	Length of the largest cycle.

// Sample Input:
// 23
// 4 4 1 4 13 8 8 8 0 8 14 9 5 11 -1 10 15 22 22 22 22 22 21

// Sample Output:
// 45


import java.util.*;
class Graph 
{
    int N;
    int max = 0;
    int[][] matrix;
    Graph(int N)
    {
        this.N = N;
        matrix = new int[N][N];
    }   
    void create(int src,int dest)
    {
        matrix[src][dest] = 1;
    }
    boolean isSafe(int[] ref,int ver,int ind)
    {
        if(matrix[ref[ind-1]][ver] != 1)
            return false;
        for(int itr = 0; itr < ind ; itr++)
        {
            if(ver == ref[itr])
                return false;
        }
        return true;
    }
    void Solve(int[] ref,int ind)
    {
        if(matrix[ref[ind-1]][ref[0]] == 1)
        {
            int sum = 0;
            for(int itr = 0 ; itr <  ind ; itr++)
            {
                sum+=ref[itr];
            }
            max = Math.max(max, sum);
        }
        else
        {
            for(int ver = 0 ; ver < N ; ver++)
            {
                if(isSafe(ref,ver,ind) == true)
                {
                    ref[ind] = ver;
                    Solve(ref,ind+1);
                    ref[ind] = 0;
                }
            }
        }
    }
    void find_cle()
    {
        int[] ref = new int[N];
        for(int ind = 0 ; ind < N ; ind++)
        {
            ref[0] = ind;
            Solve(ref,1);
        }
        System.out.println(max);
    }
}
public class Question3
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Graph graph = new Graph(N);
        for(int src = 0 ; src < N ; src++)
        {
            int num = input.nextInt();
            if(num != -1)
            graph.create(src, num);
        }
        graph.find_cle();
        input.close();
    }
}
