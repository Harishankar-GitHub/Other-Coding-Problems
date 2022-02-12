import java.util.Arrays;

public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6898131036979740672-DeF1
    // https://leetcode.com/problems/move-zeroes/
    // https://www.geeksforgeeks.org/move-zeroes-end-array/

    public static void main(String[] args) {
        moveZeroes(new int[]{1, 2, 0, 4, 3, 0, 5, 0});
        moveZeroes(new int[]{0, 1, 0, 3, 12});
        moveZeroes(new int[]{0});
    }

    public static void moveZeroes(int[] nums) {
        int lastNonZeroFoundAt = 0;
        int arrayLength = nums.length;

        for (int i = 0; i < arrayLength; i++) {
            int currentNum = nums[i];

            if (currentNum != 0) {
                    nums[lastNonZeroFoundAt] = currentNum;
                    lastNonZeroFoundAt++;
                }
        }

        for (int i = lastNonZeroFoundAt; i < arrayLength; i++) {
            nums[i] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }
}
