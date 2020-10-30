import java.util.Scanner;
import java.util.Stack;

public class Solution {

    // Link : https://www.hackerrank.com/challenges/balanced-brackets/problem

    // Few input examples
    // {[()]}
    // {[(])}
    // {{[[(())]]}}

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        System.out.println(isBalanced(s));

    }

    static String isBalanced(String s)
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
                    return "NO";
                }
                else
                {
                    char poppedValue = stack.pop();

                    if (poppedValue == '(' && c != ')')
                    {
                        return "NO";
                    }
                    else if (poppedValue == '{' && c != '}')
                    {
                        return "NO";
                    }
                    else if (poppedValue == '[' && c != ']')
                    {
                        return "NO";
                    }
                }
            }
        }
        if (stack.isEmpty())
        {
            return "YES";
        }
        else
        {
            return "NO";
        }
    }
}
