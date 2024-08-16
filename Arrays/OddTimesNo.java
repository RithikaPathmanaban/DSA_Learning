import java.util.*;
class OddTimesNo{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int ind = 0;ind <N;ind++){
            arr[ind] = sc.nextInt();
        }
        int ref = 0;
        for(int ind = 0;ind<N;ind++){
            ref ^= arr[ind];
        }
        System.out.println(ref);
        sc.close();
    }
}