import java.util.Arrays;

public class Solution
{
    // Problem statement: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/

    public static void main(String[] args)
    {
        int[] nums = {8, 1, 2, 2, 3};

        System.out.println(Arrays.toString(smallerNumbersThanCurrent_my_solution(nums)));
        System.out.println(Arrays.toString(smallerNumbersThanCurrent_another_solution(nums)));
    }

    public static int[] smallerNumbersThanCurrent_my_solution(int[] nums)
    {
        int length = nums.length;
        int[] result = new int[length];

        for (int i = 0; i < length; i++)
        {
            int count = 0;

            for (int j = 0; j < length; j++)
            {
                if (j != i && nums[j] != nums[i] && nums[j] < nums[i])
                {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    // Solution: https://www.youtube.com/watch?v=xJ31gbEll9A, https://www.youtube.com/watch?v=eHqwoWiMDfY
    public static int[] smallerNumbersThanCurrent_another_solution(int[] nums)
    {
        int[] count = new int[101];

        for (int i = 0; i < nums.length; i++)
        {
            count[nums[i]]++;
        }

        for (int i = 1; i <= 100; i++)
        {
            count[i] += count[i - 1];
        }

        for (int i = 0; i < nums.length; i++)
        {
            int currentNum = nums[i];
            nums [i] = currentNum != 0 ? count[currentNum -1] : 0;
        }
        return nums;
    }
}
