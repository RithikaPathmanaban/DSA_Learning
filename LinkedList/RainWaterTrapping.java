//rain water trapping
import java.util.*;
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
class DLL 
{
    Node head = null;
    Node tail = null;
    void create(int num)
    {
        Node newnode = new Node(num);
        if(head == null)
        {
            tail = head = newnode;
        }
        else 
        {
            tail.next = newnode;
            newnode.prev = tail;
            tail = newnode;
        }
    }
    Node leftmax()
    {
        int max = 0;
        Node tptr = head;
        Node left = null;
        Node Ltail = null;
        while(tptr != null)
        {
            if(max < tptr.data)
            {
                max = tptr.data;
            }
            Node newnode = new Node(max);
            if(left == null)
            {
                Ltail = left = newnode;
            }
            else 
            {
                Ltail.next = newnode;
                newnode.prev = Ltail;
                Ltail = newnode;
            }
            tptr = tptr.next;
        }
        return left;
    }
    Node rightmax()
    {
        int max = 0;
        Node tptr = tail;
        Node right = null;
        Node rtail = null;
        while(tptr != null)
        {
            if(max < tptr.data)
            {
                max = tptr.data;
            }
            Node newnode = new Node(max);
            if(right == null)
            {
                rtail = right = newnode;
            }
            else 
            {
                newnode.next = right;
                right.prev = newnode;
                right = newnode;
            }
            tptr = tptr.prev;
        }
        return right;
    }
}
public class RainWaterTrapping 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        DLL list = new DLL();
        int N = input.nextInt();
        int num;
        for(int itr = 1 ; itr <= N  ; itr++)
        {
            num = input.nextInt();
            list.create(num);
        }
        Node left = list.leftmax();
        Node right = list.rightmax();
        Node tptr1 = list.head;
        Node tptr2 = left;
        Node tptr3 = right;
        int sum = 0;
        while(tptr1 != null)
        {
            sum += ((Math.min(tptr2.data,tptr3.data)) - tptr1.data);
            tptr1 = tptr1.next;
            tptr2 = tptr2.next;
            tptr3 = tptr3.next;
        }
        System.out.println(sum);
        input.close();
    }
}



