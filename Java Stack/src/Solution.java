import java.util.Scanner;
import java.util.Stack;

class Solution{

    // Link : https://www.hackerrank.com/challenges/java-stack/problem

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext())
        {
            String input=sc.next();

            if (input.length() == 0 || input.isEmpty())
            {
                System.out.println("true");
            }
            else
            {
                if (isBalanced(input))
                {
                    System.out.println("true");
                }
                else
                {
                    System.out.println("false");
                }
            }
        }
    }

    static boolean isBalanced(String s)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(')
            {
                stack.push(c);
            }
            else if (c == '}' || c == ']' || c == ')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }
                else
                {
                    char poppedValue = stack.pop();

                    if (poppedValue == '(' && c != ')')
                    {
                        return false;
                    }
                    else if (poppedValue == '{' && c != '}')
                    {
                        return false;
                    }
                    else if (poppedValue == '[' && c != ']')
                    {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}