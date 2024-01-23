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

        System.out.println("Method 3"); // Easy to understand
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 0, Target is in the position: " + search_method_3(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 3, Target is in the position: " + search_method_3(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Array: {1}, Target: 0, Target is in the position: " + search_method_3(new int[]{1}, 0));

        System.out.println("Method 4"); // Easy to understand
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 0, Target is in the position: " + search_method_4(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println("Array: {4, 5, 6, 7, 0, 1, 2}, Target: 3, Target is in the position: " + search_method_4(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println("Array: {1}, Target: 0, Target is in the position: " + search_method_4(new int[]{1}, 0));
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

    public static int search_method_3(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            int firstNum = nums[0];
            int middleNum = nums[mid];

            if (middleNum >= firstNum && target < firstNum) {
                start = mid + 1;
            } else if (middleNum < firstNum && target >= firstNum) {
                end = mid - 1;
            } else {    // Usual Binary Search
                if (middleNum < target) {
                    start = mid + 1;
                } else if (middleNum > target) {
                    end = mid - 1;
                } else {
                    ans = mid;
                    break;
                }
            }
        }

        return ans;
    }

    public static int search_method_4(int[] nums, int target) {

        // O(logn) time | O(1) space

        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        // This while loop is to find out the index of minimum number in the array.
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int indexOfMinimumNumber = left;
        left = 0;
        right = nums.length - 1;

        // This condition is to find out whether to search in left half of the array or to the right.
        if (target >= nums[indexOfMinimumNumber] && target <= nums[right]) {
            left = indexOfMinimumNumber;
        } else {
            right = indexOfMinimumNumber;
        }

        // After finding out which half of the array to search, the below code is usual binary search to search through the array.
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
