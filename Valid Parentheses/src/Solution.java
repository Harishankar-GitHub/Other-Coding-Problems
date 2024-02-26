import java.util.Stack;

public class Solution {

    // Problem statement: https://leetcode.com/problems/valid-parentheses/description/

    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }

    public static boolean isValid(String s) {

        Stack<Character> charStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                charStack.push(s.charAt(i));
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if (charStack.isEmpty()) return false;

                char poppedChar = charStack.pop();
                if (poppedChar == '(' && currentChar != ')') return false;
                if (poppedChar == '{' && currentChar != '}') return false;
                if (poppedChar == '[' && currentChar != ']') return false;
            }
        }

        return charStack.isEmpty();
    }
}
