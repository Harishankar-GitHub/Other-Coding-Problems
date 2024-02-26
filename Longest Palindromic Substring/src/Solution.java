public class Solution {

    // Problem statement: https://leetcode.com/problems/longest-palindromic-substring/description/

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {

        // O(n^2) time | O(n) space

        int[] longestPalindromeIndices = {0,1};

        for (int i = 1; i < s.length(); i++) {
            // starting from 1 because single character is also a palindrome
            // and left side of 1st letter in a string has nothing.
            // So, starting from 1.

            int[] oddPalindrome = getPalindromeFrom(s, i - 1, i + 1);
            int[] evenPalindrome = getPalindromeFrom(s, i - 1, i);

            int[] longestPalindromeSoFar = oddPalindrome[1] - oddPalindrome[0] > evenPalindrome[1] - evenPalindrome[0]
                    ? oddPalindrome : evenPalindrome;

            longestPalindromeIndices = longestPalindromeSoFar[1] - longestPalindromeSoFar[0] > longestPalindromeIndices[1] - longestPalindromeIndices[0]
                    ? longestPalindromeSoFar : longestPalindromeIndices;
        }

        return s.substring(longestPalindromeIndices[0], longestPalindromeIndices[1]);
    }

    private static int[] getPalindromeFrom(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            left--;
            right++;
        }
        return new int[]{left+1, right};
    }
}
