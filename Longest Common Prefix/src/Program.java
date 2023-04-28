public class Program {

    // https://leetcode.com/problems/longest-common-prefix/

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        String firstWord = strs[0];
        StringBuilder longestCommonPrefix = new StringBuilder();

        for (int i = 0; i < firstWord.length(); i++) {
            for (String word : strs) {
                if (i > word.length() - 1 || (word.charAt(i) != firstWord.charAt(i))) {
                    return longestCommonPrefix.toString();
                }
            }
            longestCommonPrefix.append(firstWord.charAt(i));
        }
        return longestCommonPrefix.toString();
    }
}
