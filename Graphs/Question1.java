
// Question 1:
// You are given a maze with N cells. Each cell may have multiple entry points but no more than one exit (i.e. entry/exit points are unidirectional doors like valves). The cells are named with an integer value from 0 to N-1.

// You need to do the following:
// 1.Nearest meeting cell
// Two persons starting from any 2 cells – c1, c2, find the closest cell Cm where they can meet with shortest travel. It could be c1 or c2 or some other common meeting point. Return the cell number where they can meet. If there are two such meeting points, return the smallest point.

// Input Format:
// •First line has the number of cells N
// •Second line has list of N values of the edge[] array. edge[i] contains the cell number that can be reached from cell “I” in one step. edge[i] is -1 if the cell does not have an exit.
// •Third line contains two cell numbers whose nearest meeting cells need to be found (return -1 if there is no meeting point from the two given cells.

// Output form
// •Nearest meeting cell (nmc).

// Sample Input:
// 23
// 4 4 1 4 13 8 8 8 0 8 14 9 5 11 -1 10 15 22 22 22 22 22 21
// 9 2

// Sample Output:
// 4


import java.util.*;
class Graph 
{
    int N;
    int[][] matrix;
    int top = -1;
    Graph(int N)
    {
        this.N = N;
        matrix = new int[N][N];
    }
    void create(int src,int dest)
    {
        matrix[src][dest] = 1;
    }
    void dfs_helper(int[] visited,int[] path,int src)
    {
        visited[src] = 1;
        path[++top] = src;
        for(int ind = 0 ; ind < N ; ind++)
        {
            if(visited[ind] != 1 && matrix[src][ind] == 1)
            {
                dfs_helper(visited,path,ind);
            }
        }
    }
    void dfs(int src1,int src2)
    {
        int[] visited1 = new int[N];
        int[] visited2 = new int[N];
        int[] path1 = new int[N];
        int[] path2 = new int[N];
        int size1 = 0;
        int size2 = 0;
        int ind1 = 0;
        int ind2 = 0;
        dfs_helper(visited1,path1,src1);
        size1 = top;
        top = -1;
      
        dfs_helper(visited2,path2,src2);
        size2 = top;
        int[] ref = new int[N];
        int common = 0;
        while(ind1 <= size1 && ind2 <= size2)
        { 
            if(ref[path1[ind1]] == 0)
                ref[path1[ind1]] = 1;
            else 
            {
                common = path1[ind1];
                break;
            }
            ind1++;
            if(ref[path2[ind2]] == 0)
                ref[path2[ind2]] = 1;
            else 
            {
                common = path2[ind2];
                break;
            }
            ind2++;
        }
        System.out.println(common);
    }
}
public class Question1
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Graph graph = new Graph(N);
        for(int src = 0  ; src < N ; src++)
        {
            int num = input.nextInt();
            if(num != -1)
            graph.create(src, num);
        }
        int src1 = input.nextInt();
        int src2 = input.nextInt();
        graph.dfs(src1,src2);
        input.close();
    }
}





