public class Program {

    // https://leetcode.com/problems/maximum-subarray/

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int currentMaxSum = nums[0];
        int maxSumSoFar = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMaxSum = Math.max(currentMaxSum + nums[i], nums[i]);
            maxSumSoFar = Math.max(currentMaxSum, maxSumSoFar);
        }

        return maxSumSoFar;
    }
}
