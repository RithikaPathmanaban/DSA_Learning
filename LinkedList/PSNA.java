import java.util.*;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head = null;
    void create(int num){
        Node newnode = new Node(num);
        if(head==null) head = newnode;
        else{
            Node tptr = head;
            while(tptr.next!=null) {
                tptr = tptr.next;
            }
            tptr .next = newnode;
        }
    }
    void display(){
        Node tptr = head;
        while(tptr!=null){
            System.out.print(tptr.data+" ");
            tptr = tptr.next;
        }
    }
}
public class PSNA {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        int num;
                while(true)
                {
                    num = sc.nextInt();
                    if(num == -1) break;
                    list.create(num);
                }
                list.display();
        sc.close();
    }
}
