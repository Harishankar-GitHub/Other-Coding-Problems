import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // Problem statement: https://leetcode.com/problems/group-anagrams/description/

    public static void main(String[] args) {
        printList(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
        printList(groupAnagrams(new String[]{""}));
        printList(groupAnagrams(new String[]{"a"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramsGroup = new HashMap<>();

        for (String word : strs) {
            char[] wordArr = word.toCharArray();
            Arrays.sort(wordArr);
            String sortedWord = String.valueOf(wordArr);

            List<String> currentWordAnagrams = anagramsGroup.getOrDefault(sortedWord, new ArrayList<>());
            currentWordAnagrams.add(word);
            anagramsGroup.put(sortedWord, currentWordAnagrams);
        }

        return new ArrayList<>(anagramsGroup.values());
    }

    private static void printList(List<List<String>> list) {
        list.forEach(System.out::println);
    }
}
