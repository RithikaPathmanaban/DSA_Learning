//post fix conversion && expression evaluation
import java.util.*;
public class Expression 
{
    public static int prec(char ch)
    {
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/' || ch == '%') return 2;
        if(ch == '^') return 3;
        return 0;
    }
    public static int evaluate(int num1,int num2,char op)
    {
        switch(op)
        {
            case '+': return num1+num2;
            case '-': return num1-num2; 
            case '*': return num1*num2;
            case '/': return num1/num2;
            case '%': return num1%num2;
            case '^': return (int)Math.pow(num1,num2);
        }
        return 0;
    }
    public static void eval(char[] post,int len)
    {
        int[] stack = new int[len/2+1];
        int top = -1;
        for(int ind = 0 ; ind < len ; ind++)
        {
            if(post[ind] >= '0' && post[ind] <= '9')
            {
                stack[++top] = (int)(post[ind]-'0');
            }
            else 
            {
                int num2 = stack[top--];
                int num1 = stack[top--];
                stack[++top] = evaluate(num1,num2,post[ind]);
            }
        }
        System.out.println(stack[top]);
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
        eval(post,post_top);
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




