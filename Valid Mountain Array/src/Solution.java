public class Solution {

    // Problem statement: https://leetcode.com/problems/valid-mountain-array/

    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{2, 1}));
        System.out.println(validMountainArray(new int[]{3, 5, 5}));
        System.out.println(validMountainArray(new int[]{0, 3, 2, 1}));
    }

    public static boolean validMountainArray(int[] arr) {

        // O(n) time | O(1) space

        int length = arr.length;
        int i = 0;

        // Move till it is increasing.
        while (i+1 < length && arr[i] < arr[i+1]) {
            i++;
        }

        // If peak is 1st element or last element, return false.
        if (i == 0 || i == length - 1) return false;

        // Move till it is decreasing.
        while (i+1 < length && arr[i] > arr[i+1]) {
            i++;
        }

        // Return true if i reached last element.
        return i == length - 1;
    }
}
