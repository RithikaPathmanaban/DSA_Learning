import java.util.*;
public class MovingZeroes {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }
        int i = 0;
        int j = N - 1;
        while(i < j){
            if(arr[i] != 0 && arr[j] == 0){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            } else if(arr[i] == 0) {
                i++;
            } else if(arr[j] != 0) {
                j--;
            }
        }
        for(int ind = 0; ind < N; ind++){
            System.out.print(arr[ind] + " ");
        }
    }
}
