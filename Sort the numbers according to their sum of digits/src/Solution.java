import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6882943976845008896-z41_
    // https://www.geeksforgeeks.org/sort-the-numbers-according-to-their-sum-of-digits/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortTheNumbersAccordingToTheirSumOfDigits(new int[]{12, 10, 102, 31, 15})));
    }

    public static int[] sortTheNumbersAccordingToTheirSumOfDigits(int[] array) {

        // O(n) time | O(n) space

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for (int num : array) {
            map.put(num, sumOfDigits(num));
        }

        LinkedList<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByValue());

        // The above sort can also be done like the below implementation
        /*Collections.sort(entries, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });*/

        for (int i = 0; i < entries.size(); i++) {
            array[i] = entries.get(i).getKey();
        }

        return array;
    }

    private static Integer sumOfDigits(int num) {
        int sum = 0;

        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }

        return sum;
    }
}
