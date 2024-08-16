//Question 2: 
//Problem Description : You are given a maze with N cells. Each cell may have multiple entry points but not more than one exit (i.e. //entry/exit points are unidirectional doors like valves).

//The cells are named with an integer from 0 to N-1.

//You have to find : Find the node number of maximum weight node (Weight of a node is the sum of all nodes pointing to that node).

//INPUT FORMAT :

//The first line contains the number of cells N.
//The second line has a list of N values of the edge[ ] array, where edge[i] conatins the cell number that can be reached from cell 'i' in //one step. edge[i] is -1 if the ith doesn't have ans exit.
//OUTPUT FORMAT :

//First line denotes the node number with maximum weight node.
//Sample Input :
//23
//4 4 1 4 13 8 8 8 0 8 14 9 15 11 -1 10 15 22 22 22 22 22 21

//Sample Output :
//22
 


//solved


import java.util.*;
class  Node 
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
class Graph 
{
    int N;
    Node[] head;
    Graph(int N)
    {
        this.N = N;
        head = new Node[N];
    }
    void create(int src,int dest)
    {
        Node newnode = new Node(src);
        if(head[dest] == null) 
            head[dest] = newnode;
        else 
        {
            newnode.next = head[dest];
            head[dest] = newnode;
        }
    }
    void find_vertex()
    {
        int max = 0;
        int vertex = 0;
        for(int ind = 0 ; ind < N ; ind++)
        {
            Node tptr = head[ind];
            int sum = 0;
            while(tptr != null)
            {
                sum+=tptr.data;
                tptr = tptr.next;
            }
            if(max < sum)
            {
                max = sum;
                vertex = ind;
            }
        }
        System.out.println(vertex);
    }
}
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int dest;
        Graph graph = new Graph(N);
        for(int src = 0 ; src < N ; src++)
        {
            dest = input.nextInt();
	    if(dest != -1)
            	graph.create(src,dest);
        }
        graph.find_vertex();
        input.close();
    }
}

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

//     void create(int src, int dest)
//     {
//         // Here we assume that the edge direction is from src to dest
//         matrix[dest][src] = 1;
//     }

//     void find_vertex()
//     {
//         int max = 0;
//         int vertex = 0;

//         for (int ind = 0; ind < N; ind++)
//         {
//             int sum = 0;
//             for (int j = 0; j < N; j++)
//             {
//                 if (matrix[ind][j] == 1)
//                 {
//                     sum += j;
//                 }
//             }
//             if (max < sum)
//             {
//                 max = sum;
//                 vertex = ind;
//             }
//         }
//         System.out.println(vertex);
//     }
// }

// public class Question2 
// {
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         int N = input.nextInt();
//         int num;
//         Graph graph = new Graph(N);

//         for (int src = 0; src < N; src++)
//         {
//             num = input.nextInt();
//             if (num != -1)
//             {
//                 graph.create(src, num);
//             }
//         }
        
//         graph.find_vertex();
//         input.close();
//     }
// }
