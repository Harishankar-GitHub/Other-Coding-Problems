import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution
{
    // Problem statement: https://leetcode.com/problems/missing-number/

    public static void main(String[] args)
    {
        int[] nums = {3,0,1};
//        int[] nums = {0,1};
//        int[] nums = {9,6,4,2,3,5,7,0,1};
//        int[] nums = {0};

        System.out.println(missingNumber_another_array(nums));
        System.out.println(missingNumber_hashSet(nums));
        System.out.println(missingNumber_bit_manipulation(nums));
        System.out.println(missingNumber_gauss_formula(nums));
        System.out.println(missingNumber_sorting(nums));
        System.out.println(missingNumber_sorting_another_method(nums));
    }

    // Using another array
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int missingNumber_another_array(int[] nums)
    {
        int maxRange = nums.length;

        int[] numsArray = new int[maxRange + 1];

        for (int i = 0; i < maxRange; i++)        // With this For Loop, the code runs in 0 ms.
        {
            numsArray[nums[i]] = 1;
        }

//        for (int num : nums)                      // With this For Loop, the code runs in 1 ms.
//        {
//            numsArray[num] = 1;
//        }

        for (int i = 0; i < numsArray.length; i++)
        {
            if (numsArray[i] == 0) return i;
        }
        return -1;
    }

    // Sorting
    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public static int missingNumber_sorting(int[] nums)
    {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length - 1] != nums.length) return nums.length;

        // Ensure that 0 is at the first index
        else if (nums[0] != 0) return 0;

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++)
        {
            int expectedNum = nums[i - 1] + 1;
            if (nums[i] != expectedNum) return expectedNum;
        }

        // Array was not missing any numbers
        return -1;
    }

    // Sorting - Another method
    // Time complexity: O(nlogn)
    // Space complexity: O(1)
    public static int missingNumber_sorting_another_method(int[] nums)
    {
        Arrays.sort(nums);

        // Ensure that n is at the last index
        if (nums[nums.length - 1] != nums.length) return nums.length;

            // Ensure that 0 is at the first index
        else if (nums[0] != 0) return 0;

        // If we get here, then the missing number is on the range (0, n)
        for (int i = 1; i < nums.length; i++)
        {
            if (i != nums[i]) return i;
        }

        // Array was not missing any numbers
        return -1;
    }

    // HashSet
    // Time complexity: O(n)
    // Space complexity: O(n)
    public static int missingNumber_hashSet(int[] nums)
    {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++)
        {
            if (!numSet.contains(number)) return number;
        }
        return -1;
    }

    // Bit Manipulation
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int missingNumber_bit_manipulation(int[] nums)
    {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++)
        {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Gauss Formula
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int missingNumber_gauss_formula(int[] nums)
    {
        int expectedSum = nums.length * (nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }
}