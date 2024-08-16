import java.util.*;
public class RemoveDuplicates
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];
        for(int ind = 0 ; ind < N ; ind++)
        {
            arr[ind] = input.nextInt();
        }
        int left = 0;
        int right = 1;
        while(right < N)
        {
            if(arr[left] == arr[right])
            {
                arr[right++] = 0;
            }
            else 
            {
                arr[++left] = arr[right];
                arr[right++] = 0;
            }
        }
        for(int ind = 0 ; ind < right ; ind++)
        {
            System.out.print(arr[ind]+" ");
        }
        input.close();
    }
}

//             a                   b
// 1 1 1 1 1 2 2 2 3 3 3 4 4 5 6 6 7 
// 1 2 3 4 5 6 7
