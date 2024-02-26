public class Solution {

    // Problem statement: https://leetcode.com/problems/valid-palindrome/description/

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindrome("race a car"));
        System.out.println(isPalindrome(" "));
    }

    public static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end -= 1;
            } else {
                if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start += 1;
                end -= 1;
            }
        }

        return true;
    }
}
