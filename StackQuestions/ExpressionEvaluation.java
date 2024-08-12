package StackQuestions;


//infix to postfix and evaluating the expression using the stack
import java.util.*;
public class ExpressionEvaluation
{
    public static int prec(char ch)
    {
        if(ch == '+' || ch == '-') return 1;
        if(ch == '*' || ch == '/' || ch == '%') return 2;
        if(ch == '^') return 3;
        return 0;
    }
    public static int eval(char[] post,int len)
    {
        int[] stack = new int[len];
        int top = -1;
        for(int i = 0;i<len;i++){
            char ch=post[i];
            if(ch>='0' && ch<='9')
                stack[++top] =ch-'0';
            else{
                int n2 = stack[top--];
                int n1 = stack[top--];
                int ans = 0;
                switch(ch){
                    case '*':
                        ans = n1*n2;
                        break;
                    case '+': 
                        ans = n1+n2;
                        break;
                    case '^':
                        ans = (int)Math.pow(n1,n2);
                        break;
                    case '/':
                        ans = n1/n2;
                        break;
                    case '-':
                        ans = n1-n2;
                        break;
                }
                stack[++top] = ans;
            }
        }
        return stack[top];
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

        int result = eval(post, post_top + 1);
        System.out.println(result);
    }
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        String infix = input.next();
        postfix_conversion(infix);
        input.close();
    }
}

//infix(input) = 8+2*(4^2/1)-6+8/2
//postfix =  8242^1/*+6-82/+
//output = 38