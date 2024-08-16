//Binary tree using Queue && in,pre,post traversal
import java.util.*;
class Node
{
    int data;
    Node left;
    Node right;
    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTreeDefine
{
    int N;
    Node[] Queue;
    int front = -1;
    int rear = -1;
    Node root = null;
    BinaryTreeDefine(int N)
    {
        this.N = N;
        Queue = new Node[N];
    }
    void create(int num)
    {
        Node newnode = new Node(num);
        if(root == null)
        {
            root = newnode;
            front++;
            rear++;
            Queue[front] = newnode;
        }
        else 
        {
            if(Queue[front].left == null)
                Queue[front].left = newnode;
            else 
            {
                Queue[front].right = newnode;
                front++;
            }
            Queue[++rear] = newnode;
        }
    }
    void inorder(Node tptr)
    {
        if(tptr != null)
        {
            inorder(tptr.left);
            System.out.print(tptr.data+" ");
            inorder(tptr.right);
        }
    }
    void preorder(Node tptr)
    {
        if(tptr != null)
        {
            System.out.print(tptr.data+" ");
            preorder(tptr.left);
            preorder(tptr.right);
        }
    }
    void postorder(Node tptr)
    {
        if(tptr != null)
        {
            postorder(tptr.left);
            postorder(tptr.right);
            System.out.print(tptr.data+" ");
        }
    }
    void display()
    {
        inorder(root);
        System.out.println();
        preorder(root);
        System.out.println();
        postorder(root);
    }
}
public class BinaryTree
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        BinaryTreeDefine tree = new BinaryTreeDefine(N);
        int num;
        for(int itr = 1 ; itr <= N ; itr++)
        {
            num = input.nextInt();
            tree.create(num);
        }
        tree.display();
        input.close();
    }
}


