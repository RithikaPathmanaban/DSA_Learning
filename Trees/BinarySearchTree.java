


//Binary search tree
// import java.util.*;
// class Node 
// {
//     int data;
//     Node right;
//     Node left;
//     Node(int num)
//     {
//         data = num;
//         right = null;
//         left = null;
//     }
// }
// class BinarySearchTree
// {
//     Node root = null;
//     void create(int num)
//     {
//         Node newnode = new Node(num);
//         if(root == null)
//             root = newnode;
//         else 
//         {
//             Node tptr = null;
//             Node temp = null;
//             for(tptr=root;tptr!=null;temp=tptr,tptr=(num>tptr.data)?tptr.right:tptr.left);
//             if(temp.data < num)
//                 temp.right = newnode;
//             else
//                 temp.left = newnode;
//         }
//     }
//     void inorder(Node tptr)
//     {
//         if(tptr != null)
//         {
//             inorder(tptr.left);
//             System.out.print(tptr.data+" ");
//             inorder(tptr.right);
//         }
//     }
//     void display()
//     {
//         inorder(root);
//     }
// }
// public class PSNA 
// {
//     public static void main(String[] args) 
//     {
//         Scanner input = new Scanner(System.in);
//         BinarySearchTree tree = new BinarySearchTree();
//         int num;
//         while(true)
//         {
//             num = input.nextInt();
//             if(num == -1) break;
//             tree.create(num);
//         }
//         tree.display();
//         input.close();
//     }
// }










//Binary search tree recursive approach
import java.util.*;
class Node 
{
    int data;
    Node right;
    Node left;
    Node(int num)
    {
        data = num;
        right = null;
        left = null;
    }
}
class BinarySearchTreeDefine
{
    Node root = null;
    Node addnum(int num,Node root)
    {
        if(root == null)
            return  new Node(num);
        if(root.data < num)
            root.right = addnum(num,root.right);
        else 
            root.left = addnum(num,root.left);
        return root;
    }
    void create(int num)
    {
        root = addnum(num,root);
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
    void display()
    {
        inorder(root);
    }
}
public class BinarySearchTree
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        BinarySearchTreeDefine tree = new BinarySearchTreeDefine();
        int num;
        while(true)
        {
            num = input.nextInt();
            if(num == -1) break;
            tree.create(num);
        }
        tree.display();
        input.close();
    }
}







