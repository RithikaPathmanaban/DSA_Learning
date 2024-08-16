// Breaking an Integer to get Maximum Product

// Given an number n, the task is to segregate the number in such a way that multiplication of its parts is maximized.

// Input : n = 10
// Output : 36
// exp:
// 10 = 4 + 3 + 3 and 4 * 3 * 3 = 36
// is maximum possible product.

// Input : n = 8
// Output : 18
// 8 = 2 + 3 + 3 and 2 * 3 * 3 = 18
// is maximum possible product.








// import java.util.*;
// public class MaximumProduct 
// {
//     static int max = 0;
//     public static void Solve(int N,int[] ref,int ind)
//     {
//         if(N == 0)
//         {
//             int pro = 1;
//             for(int itr = 0 ; itr < ind ; itr++)
//             {
//                 pro *= ref[itr];
//             }
//             max = Math.max(max,pro);
//         }
//         else 
//         {
//             for(int val = 1 ; val <= N ; val++)
//             {
//                 ref[ind] = val;
//                 Solve(N-val, ref, ind+1);
//             }
//         }
//     }
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         int N = input.nextInt();
//         int[] ref = new int[N];
//         Solve(N,ref,0);
//         System.out.println(max);
//         input.close();
//     }
// }


// Optimised solution


import java.util.*;
public class MaximumProduct
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int val = 0;
        if(N%3 == 0)
            val = (int)Math.pow(3,N/3);
        else if(N%3 == 1)
            val = (int)Math.pow(3,N/3-1) * 4;
        else 
            val = (int)Math.pow(3,N/3) * 2;
        System.out.println(val);
        input.close();
    }
}