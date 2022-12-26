public class Solution {

    // Problem statement: https://leetcode.com/problems/peak-index-in-a-mountain-array/

    public static void main(String[] args) {
        System.out.println("Solution 1");
        System.out.println(peakIndexInMountainArray_solution_1(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_1(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_1(new int[]{0, 10, 5, 2}));

        System.out.println("Solution 2");
        System.out.println(peakIndexInMountainArray_solution_2(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_2(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_2(new int[]{0, 10, 5, 2}));

        System.out.println("Solution 3");
        System.out.println(peakIndexInMountainArray_solution_3(new int[]{0, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_3(new int[]{0, 2, 1, 0}));
        System.out.println(peakIndexInMountainArray_solution_3(new int[]{0, 10, 5, 2}));
    }

    public static int peakIndexInMountainArray_solution_1(int[] arr) {

        // O(n) time | O(1) space

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
                return i;
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray_solution_2(int[] arr) {

        // O(n) time | O(1) space

        int i = 0;
        while (arr[i] < arr[i+1]) i++;
        return i;
    }

    public static int peakIndexInMountainArray_solution_3(int[] arr) {

        // O(logn) time | O(1) space
        // Using Binary Search.

        int lo = 0, hi = arr.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < arr[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
