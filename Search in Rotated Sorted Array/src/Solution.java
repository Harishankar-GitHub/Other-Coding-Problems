public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6891008311140171777-TlCY
    // https://leetcode.com/problems/search-in-rotated-sorted-array/
    // https://www.baeldung.com/cs/sorted-and-rotated-array-search


    public static void main(String[] args) {
        System.out.println("Method 1");
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 0, Target is in the position: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 3, Target is in the position: " + search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Array: {1}, Target: 0, Target is in the position: " + search(new int[]{1}, 0));

        System.out.println("Method 2");
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 0, Target is in the position: " + search_method_2(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 3, Target is in the position: " + search_method_2(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Array: {1}, Target: 0, Target is in the position: " + search_method_2(new int[]{1}, 0));
    }

    public static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        int firstNum = nums[start];
        int lastNum = nums[end];

        if (target == firstNum) return start;
        if (target == lastNum) return end;

        if (Math.abs(target - firstNum) < Math.abs(target - lastNum)) {
            for (int i = start; i <= end; i++) {
                if (nums[i] == target) return i;
            }
        } else {
            for (int i = end; i >= start; i--) {
                if (nums[i] == target) return i;
            }
        }
        return -1;
    }

    public static int search_method_2(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            int num;

            int firstNum = nums[0];
            int middleNum = nums[mid];

            // Condition to check if middleNum and target are on same side.
            if ((middleNum < firstNum) == (target < firstNum)) {
                num = middleNum;
            } else {
                num = target < firstNum ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            if (num < target) {
                start = mid + 1;
            } else if (num > target) {
                end = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
