public class Program {

    // https://leetcode.com/problems/maximum-subarray/

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) currentSum = 0;

            currentSum = currentSum + nums[i];

            if (currentSum > maxSoFar) maxSoFar = currentSum;
        }

        return maxSoFar;
    }
}
