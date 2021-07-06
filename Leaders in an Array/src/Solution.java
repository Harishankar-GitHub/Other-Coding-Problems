public class Solution
{
    // Problem statement:
    // https://www.geeksforgeeks.org/leaders-in-an-array/
    // https://www.linkedin.com/posts/coding-club_asked-activity-6814771093769920512-xGWO
    // https://www.careercup.com/question?id=5743117907001344

    public static void main(String[] args)
    {
           int[] nums = {7,4,7,5,3};

        leadersInAnArray_using_2_for_loops(nums);
        System.out.println();
        leadersInAnArray_check_from_right(nums);
    }

    // Time Complexity: O(n*n)
    // Space Complexity: O(1)
    public static void leadersInAnArray_using_2_for_loops(int[] nums)
    {
        int length = nums.length;

        for (int i = 0; i < length; i++)
        {
            int j;
            for (j = i + 1; j < length; j++)
            {
                if (nums[i] < nums[j]) break;
            }

            if (j == length) System.out.print(nums[i] + " ");
        }
    }

    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void leadersInAnArray_check_from_right(int[] nums)
    {
        int length = nums.length;
        int max_from_right = nums[nums.length - 1];

        System.out.print(max_from_right + " ");

        for (int i = length - 2; i >= 0; i--)
        {
            if (nums[i] >= max_from_right)
            {
                max_from_right = nums[i];
                System.out.print(max_from_right + " ");
            }
        }
    }
}
