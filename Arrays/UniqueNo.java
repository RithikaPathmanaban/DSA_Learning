import java.util.Scanner;
public class UniqueNo
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
        int ref = 0;
        for(int ind = 0 ; ind < N ; ind++)
        {
            ref ^= arr[ind];
        }
        System.out.println(ref);
        input.close();
    }
}


//             a                   b
// 1 2 3 4 5 6 7 2 3 3 3 4 4 5 6 6 7 
// 1 2 3 4 5 6 7
