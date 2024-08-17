import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class RadixSort {
    public static int find_dig(int[] arr){
        int size = arr.length;
        int max = arr[0];
        for(int ind = 1;ind<size;ind++){
            max = Math.max(max,arr[ind]);
        }
        return (int)Math.log10(max)+1; //finding digit count
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr = {2,43,346,334,35476,42354,4,23,2,235,345};
        int digits = find_dig(arr);
        int size = arr.length;
        int place_val = 10;
        while(digits!=0){
            Node[] head = new Node[10];
            Node[]  tail = new Node[10];
            for(int ind = 0;ind<size;ind++){
                int digit = (arr[ind]/place_val)%10;
                Node newnode = new Node(arr[ind]);
                if(head[digit]==null){
                    tail[digit]=head[digit]=newnode;
                }
                else{
                    tail[digit].next=newnode;
                    tail[digit]=newnode;
                }
            }
            for(int ind = 0;ind<0;ind++){
                Node tptr = head[ind];
                while(tptr!=null){
                    System.out.println(tptr.data+" ");
                    tptr = tptr.next;
                }
                System.out.println();
            }
            System.out.println();
            place_val*=10;
            digits--;
        }
        sc.close();
    }
}
