public class Solution {

    // Problem statement: https://leetcode.com/problems/find-peak-element/description/

    public static void main(String[] args) {
        System.out.println(findPeakElement(new int[]{1, 2, 3, 1}));
        System.out.println(findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 4}));
    }

    public static int findPeakElement(int[] nums) {

        // O(logn) time | O(1) space
        // Using Binary Search.

        int lo = 0, hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1])
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }
}
