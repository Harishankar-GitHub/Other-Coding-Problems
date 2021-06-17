import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution
{
    // Problem statement: https://leetcode.com/problems/majority-element/

    public static void main(String[] args)
    {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement_HashMap(nums));
        System.out.println(majorityElement_Boyer_Moore(nums));
        System.out.println(majorityElement_Brute_Force(nums));
        System.out.println(majorityElement_Sorting(nums));
    }

    // HashMap
    // Time complexity : O(n)
    // Space complexity : O(n)
    public static int majorityElement_HashMap(int[] nums)
    {
        int majorityCount = nums.length / 2;

        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer num : nums)
        {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if (countMap.get(num) > majorityCount)
            {
                return num;
            }
        }

        for (Map.Entry<Integer, Integer> element : countMap.entrySet())
        {
            if (element.getValue() > majorityCount)
            {
                return element.getKey();
            }
        }
        return -1;
    }

    // Sorting
    // Time complexity : O(nlogn)
    // Space complexity :
    // O(1) - When using Arrays.sort()
    // O(n) - When manually sorting
    public static int majorityElement_Sorting(int[] nums)
    {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Boyer-Moore Voting Algorithm
    // Time complexity : O(n)
    // Space complexity : O(1)
    public static int majorityElement_Boyer_Moore(int[] nums)
    {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    // Brute Force
    // Time complexity : O(n^2)
    // Space complexity : O(1)
    public static int majorityElement_Brute_Force(int[] nums)
    {
        int majorityCount = nums.length / 2;

        for (int num : nums)
        {
            int count = 0;
            for (int currentNum : nums)
            {
                if (num == currentNum)
                {
                    count += 1;
                }
            }
            if (count > majorityCount)
            {
                return num;
            }
        }
        return -1;
    }
}
