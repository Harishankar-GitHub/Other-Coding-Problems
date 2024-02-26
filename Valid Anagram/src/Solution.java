import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/valid-anagram/description/

    public static void main(String[] args) {
        System.out.println(isAnagram_method_1("anagram", "nagaram"));   // true
        System.out.println(isAnagram_method_1("rat", "car"));   // false

        System.out.println(isAnagram_method_2("anagram", "nagaram"));   // true
        System.out.println(isAnagram_method_2("rat", "car"));   // false

        System.out.println(isAnagram_method_3("anagram", "nagaram"));   // true
        System.out.println(isAnagram_method_3("rat", "car"));   // false
    }

    public static boolean isAnagram_method_1(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();

        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static boolean isAnagram_method_2(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCountArr = new int[26];

        for (char c : s.toCharArray()) {
            charCountArr[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            charCountArr[c - 'a']--;
        }

        for (int count : charCountArr) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram_method_3(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCountArr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            charCountArr[s.charAt(i) - 'a']++;
            charCountArr[t.charAt(i) - 'a']--;
        }

        for (int count : charCountArr) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
