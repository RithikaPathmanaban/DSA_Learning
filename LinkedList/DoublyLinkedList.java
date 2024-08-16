import java.util.*;
class Node 
{
    int data;
    Node next;
    Node prev;
    Node(int num)
    {
        data = num;
        prev = null;
        next = null;
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
            head = newnode;
            tail = newnode;
        }
        else 
        {
            Node tptr = null;
            for(tptr = head ; tptr != null && num > tptr.data ; tptr = tptr.next);
            if(tptr == head)
            {
                newnode.next = head;
                head.prev = newnode;
                head = newnode;
            }
            else if(tptr == null)
            {
                newnode.prev = tail;
                tail.next = newnode;
                tail = newnode;
            }
            else 
            {
                tptr.prev.next = newnode;
                newnode.prev = tptr.prev;
                newnode.next = tptr;
                tptr.prev = newnode;
            }
        }
    }
    void display()
    {
        Node tptr = tail;
        while(tptr != null)
        {
            System.out.print(tptr.data+" ");
            tptr = tptr.prev;
        }
    }
}
public class DoublyLinkedList
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        DLL list = new DLL();
        int num;
        while(true)
        {
            num = input.nextInt();
            if(num == -1) break;
            list.create(num);
        }
        list.display();
        input.close();
    }
}

// approach 2
// import java.util.*;
// class Node 
// {
//     int data;
//     Node next;
//     Node prev;
//     Node(int num)
//     {
//         data = num;
//         prev = null;
//         next = null;
//     }
// }
// class DLL 
// {
//     Node head = null;
//     Node tail = null;
//     void create(int num)
//     {
//         Node newnode = new Node(num);
//         if(head == null)
//         {
//             head = newnode;
//             tail = newnode;
//         }
//         else 
//         {
//             Node tptr = null;
//             Node temp = null;
//             for(tptr = head ; tptr != null && num > tptr.data ; temp = tptr , tptr = tptr.next);
//             if(tptr == head)
//             {
//                 newnode.next = head;
//                 head.prev = newnode;
//                 head = newnode;
//             }
//             else if(tptr == null)
//             {
//                 newnode.prev = temp;
//                 temp.next = newnode;
//                 tail = newnode;
//             }
//             else 
//             {
//                 temp.next = newnode;
//                 newnode.prev = temp;
//                 newnode.next = tptr;
//                 tptr.prev = newnode;
//             }
//         }
//     }
//     void display()
//     {
//         Node tptr = tail;
//         while(tptr != null)
//         {
//             System.out.print(tptr.data+" ");
//             tptr = tptr.prev;
//         }
//     }
// }
// public class DoublyLinkedList
// {
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         DLL list = new DLL();
//         int num;
//         while(true)
//         {
//             num = input.nextInt();
//             if(num == -1) break;
//             list.create(num);
//         }
//         list.display();
//         input.close();
//     }
// }



