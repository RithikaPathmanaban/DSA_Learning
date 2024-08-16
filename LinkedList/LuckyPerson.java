

// Lucky Person

// Given that N person (numbered 1 to N) standing as to form a circle. They all have the gun in their hand which is pointed to their leftmost Partner. 

// Every one shoots such that 1 shoot 2, 3 shoots 4, 5 shoots 6 …. (N-1)the shoot N (if N is even otherwise N shoots 1). 
// Again on the second iteration, they shoot the rest of remains as above mentioned logic (now for n as even, 1 will shoot to 3, 5 will shoot to 7 and so on). 

// The task is to find which person is the luckiest(didn’t die)?



import java.util.*;
class Node 
{
    int data;
    Node next;
    Node(int num)
    {
        data = num;
        next = null;
    }
}
public class LuckyPerson
{

    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        Node head = null;
        Node newnode = null;
        for(int val = 1 ; val <= N ; val++)
        {
            newnode = new Node(val);
            if(head == null) head = newnode;
            else 
            {
                Node tptr = head;
                while(tptr.next != null)
                {
                    tptr = tptr.next;
                }
                tptr.next = newnode;
            }
        }
        newnode.next = head;
        Node prev = head;
        Node curr = head.next;
        while(curr != curr.next)
        {
            prev.next = curr.next;
            curr = curr.next.next;
            prev = prev.next;
        }
        System.out.print(curr.data);
        input.close();
    }
}



