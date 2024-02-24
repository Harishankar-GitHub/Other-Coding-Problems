import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem statement:  https://leetcode.com/problems/longest-substring-without-repeating-characters/

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));   // 3
        System.out.println(lengthOfLongestSubstring("bbbb"));   // 1
        System.out.println(lengthOfLongestSubstring("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring("abcaacbb"));   // 3
        System.out.println(lengthOfLongestSubstring("abccacbd"));   // 4
        System.out.println(lengthOfLongestSubstring("bcadewrgd"));   // 8

        System.out.println(lengthOfLongestSubstring_Refactored_Code("abcabcbb"));   // 3
        System.out.println(lengthOfLongestSubstring_Refactored_Code("bbbb"));   // 1
        System.out.println(lengthOfLongestSubstring_Refactored_Code("pwwkew")); //3
        System.out.println(lengthOfLongestSubstring_Refactored_Code("abcaacbb"));   // 3
        System.out.println(lengthOfLongestSubstring_Refactored_Code("abccacbd"));   // 4
        System.out.println(lengthOfLongestSubstring_Refactored_Code("bcadewrgd"));   // 8
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int lengthOfLongestSubstring = 0;

        while (rightPtr < s.length()) {
            char leftChar = s.charAt(leftPtr);
            char rightChar = s.charAt(rightPtr);

            if (!charSet.contains(rightChar)) {
                charSet.add(rightChar);
                rightPtr++;
                lengthOfLongestSubstring = Math.max(charSet.size(), lengthOfLongestSubstring);
            } else {
                charSet.remove(leftChar);
                leftPtr++;
            }
        }

        return lengthOfLongestSubstring;
    }

    public static int lengthOfLongestSubstring_Refactored_Code(String s) {
        Set<Character> charSet = new HashSet<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int lengthOfLongestSubstring = 0;

        while (rightPtr < s.length()) {
            char rightChar = s.charAt(rightPtr);

            if (!charSet.contains(rightChar)) {
                charSet.add(rightChar);
                rightPtr++;
                lengthOfLongestSubstring = Math.max(charSet.size(), lengthOfLongestSubstring);
            } else {
                while (charSet.contains(rightChar)) {
                    charSet.remove(s.charAt(leftPtr));
                    leftPtr++;
                }
            }
        }

        return lengthOfLongestSubstring;
    }
}
