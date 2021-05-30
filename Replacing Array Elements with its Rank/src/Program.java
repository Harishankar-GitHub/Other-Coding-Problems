import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Program
{
    // Problem statement: https://leetcode.com/problems/rank-transform-of-an-array/

    public static void main(String[] args)
    {
        int[] intArray = {40, 10, 30, 20};

        System.out.println("Original Array: ");
        printArray(intArray);

        System.out.println("Rank of the Array: ");
        printArray(rankArrayElementsWithItsRank(intArray));
    }

    private static int[] rankArrayElementsWithItsRank(int[] arr)
    {
        int[] newArray = Arrays.copyOfRange(arr, 0, arr.length);
        Arrays.sort(newArray);

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 1;

        for (Integer a : newArray)
        {
            if (rankMap.get(a) == null)
            {
                rankMap.put(a, rank);
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++)
        {
            int element = arr[i];
            arr[i] = rankMap.get(element);
        }

        return arr;
    }

    private static void printArray(int[] array)
    {
        System.out.println(Arrays.toString(array));
    }
}
