//u r entering a room with no of coins u can collect from them or give them the no of coins based on the sign..Find the maximum number of coins u can collect
//input 8 4 -10 6 10 12 -23 16 4 -5
//output 22 

import java.util.*;
class Node{
    int data;
    Node next;
    Node(int num){
        data=num;
        next=null;
    }
}
class LinkedList{
    Node head = null;
    Node tail = null;
    void create(int num){
        Node newNode = new Node(num);
        if(head == null){
           tail = head=newNode;
        }
        else{
            tail = tail.next = newNode;
        }
    }
    int maxSum(){
            int max = head.data;
            int maxSoFar = head.data;
            Node tptr = head.next;
            while(tptr != null){
                maxSoFar += tptr.data;
                max = Math.max(max,maxSoFar);
                if(maxSoFar<0) maxSoFar=0;
                tptr = tptr.next;
            }
            return max;
    }
}
public class MaximumCoin{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int num;
        while(true){
            num = input.nextInt();
            if(num == -1) break;
            list.create(num);
        }
        int res = list.maxSum();
        System.out.println(res);
        input.close();
    }
}