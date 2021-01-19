import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main
{
    // Problem statement: https://leetcode.com/problems/max-number-of-k-sum-pairs/
    // Solution: https://www.youtube.com/watch?v=FevSHchkCeo

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter an array of numbers (Space separated):");
        String[] numbers = s.nextLine().split(" ");

        int[] numbersArr = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)
        {
            numbersArr[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("Enter a number: ");
        int k = s.nextInt();
        s.nextLine();
        s.close();

        long start1 = System.currentTimeMillis();
        System.out.println(maxOperations_method1(numbersArr, k));
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        System.out.println(maxOperations_method2(numbersArr, k));
        long end2 = System.currentTimeMillis();

        long start3 = System.currentTimeMillis();
        System.out.println(maxOperations_method3(numbersArr, k));
        long end3 = System.currentTimeMillis();

        System.out.println("Time taken for method 1: " + (end1 - start1));
        System.out.println("Time taken for method 2: " + (end2 - start2));
        System.out.println("Time taken for method 3: " + (end3 - start3));

        // Performance: Method 3 > Method 2 > Method 1
    }

    public static int maxOperations_method1(int[] nums, int k)
    {
        // Time complexity = O(n)
        // Space Complexity = O(n)

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums)
        {
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        int count = 0;

        for (int i : map.keySet())
        {
//            if (map.containsKey(i) && map.containsKey(k - i))
            if (map.containsKey(k - i))     // map.containsKey(i) check is not needed as we are iterating the
            {                               // keys that is already present in the map.
                if (i != (k-i))
                {
                    count += Math.min(map.get(i), map.get(k-i));
                    map.put(i, 0);
                    map.put(k-i, 0);
                }
                else
                {
                    count += Math.floor(map.get(i) / 2);
//                    count += map.get(i) / 2;    // When used Math.floor(), it runs little faster. Not sure why.
                    map.put(i, 0);
                }
            }
        }
        return count;
    }

    public static int maxOperations_method2(int[] nums, int k)
    {
        // Time complexity = O(nlogn)
        // Space Complexity = O(1)

        Arrays.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right)
        {
            int sum = nums[left] + nums[right];

            if (sum == k)
            {
                left++;
                right--;
                count++;
            }
            else if (sum > k)
            {
                right--;
            }
            else
            {
                left++;
            }
        }
        return count;
    }

    public static int maxOperations_method3(int[] nums, int k)
    {
        // Time complexity = O(nlogn)
        // Space Complexity = O(1)

        Arrays.sort(nums);
        int count = 0;

        int left = 0;
        int right = nums.length - 1;

        while (left < right)
        {
            int sum = nums[left] + nums[right];

            // Changing the order of IF Condition sometimes increases "Performance".

            if (sum > k) right--;
            else if (sum < k) left++;
            else
            {
                left++;
                right--;
                count++;
            }
        }
        return count;
    }
}
