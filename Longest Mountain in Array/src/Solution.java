import java.util.ArrayList;
import java.util.List;

public class Solution {

    // Problem statement: https://leetcode.com/problems/longest-mountain-in-array/

    public static void main(String[] args) {
        System.out.println("Longest Mountain in Array Solution 1: " + longestPeak_solution_1(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
        System.out.println("Longest Mountain in Array Solution 2: " + longestPeak_solution_2(new int[]{1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3}));
    }

    public static int longestPeak_solution_1(int[] array) {

        // O(n) + O(n) time | O(n) space = O(n) time | O(n) space

        List<Integer> longestPeakIndices = new ArrayList<>();
        int longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            int prevNum = array[i-1];
            int currentNum = array[i];
            int nextNum = array[i+1];

            if (currentNum > prevNum && currentNum > nextNum) {
                longestPeakIndices.add(i);
            }
        }

        for (int currentLongestPeak : longestPeakIndices) {
            int left = 0;
            int right = 0;

            for (int i = currentLongestPeak; i > 0; i--) {
                int currentNum = array[i];
                int prevNum = array[i-1];

                if (currentNum <= prevNum) break;
                left++;
            }

            for (int i = currentLongestPeak; i < array.length - 1; i++) {
                int currentNum = array[i];
                int nextNum = array[i+1];
                if (currentNum <= nextNum) break;
                right++;
            }

            int currentLongest = left + right + 1;
            // Adding 1 to left + right
            // to include the number in the currentLongestPeak.
            if (longestPeak < currentLongest) longestPeak = currentLongest;
        }

        return longestPeak;
    }

    public static int longestPeak_solution_2(int[] array) {

        // O(n) time | O(1) space

        int longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            int prevNum = array[i-1];
            int currentNum = array[i];
            int nextNum = array[i+1];

            if (currentNum > prevNum && currentNum > nextNum) {
                int left = 0;
                int right = 0;

                for (int j = i; j > 0; j--) {
                    currentNum = array[j];
                    prevNum = array[j-1];

                    if (currentNum <= prevNum) break;
                    left++;
                }

                for (int j = i; j < array.length - 1; j++) {
                    currentNum = array[j];
                    nextNum = array[j+1];

                    if (currentNum <= nextNum) break;
                    right++;
                }

                int currentLongest = left + right + 1;
                // Adding 1 to left + right
                // to include the number in the currentLongestPeak.
                if (longestPeak < currentLongest) longestPeak = currentLongest;

                i = i + right;
                // Very important condition to keep the time complexity to O(n).
                // After a valid peak is found, updating the i value to the index of next number of the current valid peak.
            }
        }
        return longestPeak;
    }
}
