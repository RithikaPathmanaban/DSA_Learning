import java.util.*;

class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    ListNode head = null;

    void create(int num) {
        ListNode newnode = new ListNode(num);
        if (head == null) {
            head = newnode;
        } else {
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newnode;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int digit1 = (l1 != null) ? l1.data : 0;
            int digit2 = (l2 != null) ? l2.data : 0;
            int sum = digit1 + digit2 + carry;
            int digit = sum % 10;
            carry = sum / 10;

            ListNode newnode = new ListNode(digit);
            tail.next = newnode;
            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }

    void display(ListNode node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

public class AddTwoNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();

        while (true) {
            int dig1 = sc.nextInt();
            if (dig1 == -1) {
                break;
            }
            list1.create(dig1);
        }
        while (true) {
            int dig2 = sc.nextInt();
            if (dig2 == -1) {
                break;
            }
            list2.create(dig2);
        }

        ListNode result = list1.addTwoNumbers(list1.head, list2.head);
        list1.display(result);

        sc.close();
    }
}
