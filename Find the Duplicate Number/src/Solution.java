public class Solution {

    // Problem statement: https://leetcode.com/problems/find-the-duplicate-number/

    public static void main(String[] args) {
        System.out.println("Duplicate Number: " + findDuplicate_negative_marking(new int[]{1,3,4,2,2}));
    }

    public static int findDuplicate_negative_marking(int[] nums) {
        int duplicateNumber = -1;

        for (int i = 0; i < nums.length; i++) {
            int currentNum = Math.abs(nums[i]);

            if (nums[currentNum] < 0) {
                duplicateNumber = currentNum;
                break;
            }

            nums[currentNum] *= -1;
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = Math.abs(nums[i]);
        }

        return duplicateNumber;
    }
}
