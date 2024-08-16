//Enumeration
// import java.util.*;
// class Graph 
// {
//     int N;
//     int[][] matrix;
//     Graph(int N)
//     {
//         this.N = N;
//         matrix = new int[N][N];
//     }
//     void create(int src,int dest)
//     {
//         matrix[src][dest] = 1;
//         matrix[dest][src] = 1;
//     }
//     boolean isSafe(int[] color, int ind,int clr)
//     {
//         for(int itr = 0 ; itr < ind ; itr++)
//         {
//             if(matrix[ind][itr] == 1 && clr == color[itr])
//                 return false;
//         }
//         return true;
//     }
//     void Solve(int[] color , int ind , int M)
//     {
//         if(ind == N)
//         {
//             for(int itr = 0 ; itr < N ; itr++)
//             {
//                 System.out.print(color[itr]+" ");
//             }
//             System.out.println();
//         }
//         else 
//         {
//             for(int clr = 0;  clr < M ; clr++)
//             {
//                 if(isSafe(color,ind,clr) == true)
//                 {
//                     color[ind] = clr;
//                     Solve(color,ind+1,M);
//                     color[ind] = 0;
//                 }
//             }
//         }
//     }
//     void graph_clr(int M)
//     {
//         int[] color = new int[N];
//         for(int ind = 0 ; ind < M ; ind++)
//         {
//             color[0] = ind;
//             Solve(color,1,M);
//         }
//     }
//     // void display()
//     // {
//     //     for(int row = 0 ; row < N ; row++)
//     //     {
//     //         for(int col = 0 ; col < N ; col++)
//     //         {
//     //             System.out.print(matrix[row][col]+" ");
//     //         }
//     //         System.out.println();
//     //     }
//     // }
// }
// public class PSNA 
// {
//     public static void main(String[] args) 
//     {
//         int N = 5;
//         Graph graph = new Graph(N);
//         graph.create(0,1);
//         graph.create(0,2);
//         graph.create(1,2);
//         graph.create(1,3);
//         graph.create(1,4);
//         graph.create(2,3);
//         graph.create(3,4);
//         // graph.display();
//         int M = 3;
//         graph.graph_clr(M);
//     }
// }










//Optimised
// import java.util.*;
// class Graph 
// {
//     int N;
//     int[][] matrix;
//     Graph(int N)
//     {
//         this.N = N;
//         matrix = new int[N][N];
//     }
//     void create(int src,int dest)
//     {
//         matrix[src][dest] = 1;
//         matrix[dest][src] = 1;
//     }
//     boolean isSafe(int[] color, int ind,int clr)
//     {
//         for(int itr = 0 ; itr < ind ; itr++)
//         {
//             if(matrix[ind][itr] == 1 && clr == color[itr])
//                 return false;
//         }
//         return true;
//     }
//     int Solve(int[] color , int ind , int M)
//     {
//         if(ind == N)
//         {
//             for(int itr = 0 ; itr < N ; itr++)
//             {
//                 System.out.print(color[itr]+" ");
//             }
//             return 1;
//         }
//         else 
//         {
//             for(int clr = 0;  clr < M ; clr++)
//             {
//                 if(isSafe(color,ind,clr) == true)
//                 {
//                     color[ind] = clr;
//                     if(Solve(color,ind+1,M) == 1) return 1;
//                     color[ind] = 0;
//                 }
//             }
//         }
//         return 0;
//     }
//     void graph_clr(int M)
//     {
//         int[] color = new int[N];
//         Solve(color,1,M);
//     }
//     // void display()
//     // {
//     //     for(int row = 0 ; row < N ; row++)
//     //     {
//     //         for(int col = 0 ; col < N ; col++)
//     //         {
//     //             System.out.print(matrix[row][col]+" ");
//     //         }
//     //         System.out.println();
//     //     }
//     // }
// }
// public class PSNA 
// {
//     public static void main(String[] args) 
//     {
//         int N = 5;
//         Graph graph = new Graph(N);
//         graph.create(0,1);
//         graph.create(0,2);
//         graph.create(1,2);
//         graph.create(1,3);
//         graph.create(1,4);
//         graph.create(2,3);
//         graph.create(3,4);
//         // graph.display();
//         int M = 3;
//         graph.graph_clr(M);
//     }
// }






//Decision making
import java.util.*;
class GraphColor
{
    int N;
    int[][] matrix;
    GraphColor(int N)
    {
        this.N = N;
        matrix = new int[N][N];
    }
    void create(int src,int dest)
    {
        matrix[src][dest] = 1;
        matrix[dest][src] = 1;
    }
    boolean isSafe(int[] color, int ind,int clr)
    {
        for(int itr = 0 ; itr < ind ; itr++)
        {
            if(matrix[ind][itr] == 1 && clr == color[itr])
                return false;
        }
        return true;
    }
    int Solve(int[] color , int ind , int M)
    {
        if(ind == N)
        {
            // for(int itr = 0 ; itr < N ; itr++)
            // {
            //     System.out.print(color[itr]+" ");
            // }
            return 1;
        }
        else 
        {
            for(int clr = 0;  clr < M ; clr++)
            {
                if(isSafe(color,ind,clr) == true)
                {
                    color[ind] = clr;
                    if(Solve(color,ind+1,M) == 1) return 1;
                    color[ind] = 0;
                }
            }
        }
        return 0;
    }
    void graph_clr(int M)
    {
        int[] color = new int[N];
        System.out.printf("%s",Solve(color,1,M) == 1 ? "Yes" : "No");
    }
    // void display()
    // {
    //     for(int row = 0 ; row < N ; row++)
    //     {
    //         for(int col = 0 ; col < N ; col++)
    //         {
    //             System.out.print(matrix[row][col]+" ");
    //         }
    //         System.out.println();
    //     }
    // }
}
public class GraphColoring 
{
    public static void main(String[] args) 
    {
        int N = 5;
        GraphColor graph = new GraphColor(N);
        graph.create(0,1);
        graph.create(0,2);
        graph.create(1,2);
        graph.create(1,3);
        graph.create(1,4);
        graph.create(2,3);
        graph.create(3,4);
        // graph.display();
        int M = 3;
        graph.graph_clr(M);
    }
}