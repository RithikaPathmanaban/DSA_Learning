
//Expression tree creation
import java.util.*;
class Node 
{
    char data;
    Node right;
    Node left;
    Node(char ch)
    {
        data = ch;
        right = null;
        left = null;
    }
}
public class ExpressionTree 
{
    static Node root = null;
    public static int prec(char ch)
    {
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/' || ch == '%') return 2;
        if(ch == '^') return 3;
        return 0;
    }
    public static void inorder(Node tptr)
    {
        if(tptr != null)
        {
            System.out.print(tptr.data+" ");
            inorder(tptr.left);
            inorder(tptr.right);
        }
    }
    public static void create_tree(char[] post,int len)
    {
        Node[] stack = new Node[len];
        int top = -1;
        for(int ind = 0 ; ind < len ; ind++)
        {
            if(post[ind] >= '0' && post[ind] <= '9')
            {
                stack[++top] = new Node(post[ind]);
            }
            else 
            {
                Node newnode = new Node(post[ind]);
                newnode.right = stack[top--];
                newnode.left = stack[top--];
                stack[++top] = newnode;
            }
        }
        root = stack[top];
        inorder(root);
    }
    public static void postfix_conversion(String infix)
    {
        int len = infix.length();
        char[] post = new char[len+1];
        char[] stack = new char[(len+1)/2];
        int post_top = -1;
        int top = -1;
        for(int ind = 0 ; ind < len ; ind++)
        {
            char ch = infix.charAt(ind);
            if(ch >= '0' && ch <= '9')
                post[++post_top] = ch;
            else if(ch == '(')
                stack[++top] = ch;
            else if(ch == ')')
            {
                while(top != -1 && stack[top] != '(')
                    post[++post_top] = stack[top--];
                top--;
            }
            else 
            {
                while(top != -1 && (prec(ch) <= prec(stack[top])))
                    post[++post_top] = stack[top--];
                stack[++top] = ch;
            }
        }
        while(top != -1)
            post[++post_top] = stack[top--];
        post[++post_top] = '\0';
        create_tree(post,post_top);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String infix = input.next();
        postfix_conversion(infix);
        input.close();
    }
}

// 8+2*(4^2/1)-6+8/2
// 8242^1/*+6-82/+



