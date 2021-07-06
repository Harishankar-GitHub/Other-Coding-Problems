class Solution
{
    // Problem statement: https://leetcode.com/problems/find-pivot-index/

    public static void main(String[] args)
    {
        int[] nums = {1,7,3,6,5,6};
//        int[] nums = {1,2,3};
//        int[] nums = {2,1,-1};

        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex_another_method(nums));
    }


    public static int pivotIndex(int[] nums)
    {
        int totalSum = 0, leftSum = 0;

        for (int num : nums) totalSum += num;

        for (int i = 0; i < nums.length; i++)
        {
            int thisNum = nums[i];
            int rightSum = totalSum - leftSum - thisNum;

            if (leftSum == rightSum) return i;

            leftSum += nums[i];
        }
        return -1;
    }

    public static int pivotIndex_another_method(int[] nums)
    {
        int totalSum = 0, leftSum = 0;

        for (int i = 0; i < nums.length; i++) totalSum += nums[i];

        for (int i = 0; i < nums.length; i++)
        {
            if (i != 0) leftSum += nums[i - 1];

            int rightSum = totalSum - leftSum - nums[i];

            if (rightSum == leftSum) return i;
        }
        return -1;
    }
}