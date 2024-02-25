public class Solution {

    // Problem statement: https://leetcode.com/problems/longest-repeating-character-replacement/description/

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("AABACBA", 1)); // 4
        System.out.println(characterReplacement("AABABAAAAAB", 1)); // 7
        System.out.println(characterReplacement("AAAB", 0));    // 3
        System.out.println(characterReplacement("AABA", 0));    // 2
        System.out.println(characterReplacement("ABAA", 0));    // 2
        System.out.println(characterReplacement("ABBB", 2));    // 4
        System.out.println(characterReplacement("ABCABBA", 2));    // 5
    }

    public static int characterReplacement(String s, int k) {
        int length = s.length();
        int[] charCounts = new int[26];

        int left = 0;
        int maxLength = 0;
        int maxRepeatingChar = 0;

        for (int right = 0; right < length; right++) {
            charCounts[s.charAt(right) - 'A']++;
            int currentCharCount = charCounts[s.charAt(right) - 'A'];
            maxRepeatingChar = Math.max(maxRepeatingChar, currentCharCount);

            // right - left + 1 = Count of total characters in the current window.

            while (right - left + 1 - maxRepeatingChar > k) {   // This can also be if condition as it executes only once in this problem.
                charCounts[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
