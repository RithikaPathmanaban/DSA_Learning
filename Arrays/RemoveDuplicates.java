import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        for(int i = 0;i<N;i++){
            arr[i] = sc.nextInt();        
        }
              
        int i = 0;
        int j = 1;
        while(j<N){
            if(arr[i]==arr[j]){
                arr[j++]=0;
            }
            else{
                arr[i+1]=arr[j];
                arr[j++]=0;
            }
        }
        for(int ind = 0;ind<j;ind++){
            System.out.print(arr[ind]+" ");
        }
    }
}

