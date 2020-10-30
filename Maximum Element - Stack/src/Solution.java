import java.util.*;

public class Solution {

    // Link : https://www.hackerrank.com/challenges/maximum-element/problem

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> maxElementsStack = new Stack<>();

        int n = s.nextInt();

        while(n > 0)
        {
            int query = s.nextInt();

            if (query == 1)
            {
                int value = s.nextInt();
                stack.push(value);

                if(maxElementsStack.isEmpty())
                {
                    maxElementsStack.push(value);
                }
                else
                {
                    int max = Math.max(value, maxElementsStack.peek());
                    maxElementsStack.push(max);
                }
            }
            else if (query == 2)
            {
                stack.pop();
                maxElementsStack.pop();
            }
            else if (query == 3)
            {
                System.out.println(maxElementsStack.peek());
            }

            n--;
        }

        s.close();
    }
}