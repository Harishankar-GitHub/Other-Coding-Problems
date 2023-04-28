public class Program {

    // https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        char needleFirstChar = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needleFirstChar) {
                if (haystack.startsWith(needle, i)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
