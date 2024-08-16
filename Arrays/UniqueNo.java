import java.util.Scanner;

public class UniqueNo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        int unique = 0;
        for (int num : arr) {
            unique ^= num;
        }
        System.out.println((unique!=0)? "The unique element is: " + unique : "No uniques elements");
    }

}
