import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main
{

    // Problem statement: https://leetcode.com/problems/kth-largest-element-in-an-array/submissions/
    // Solution: https://www.youtube.com/watch?v=ockS2ZKh7j8

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter an array of numbers (Space separated):");
        String[] numbers = s.nextLine().split(" ");

        int[] numbersArr = new int[numbers.length];
        int[] numbersArr1 = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++)
        {
            numbersArr[i] = numbersArr1[i] = Integer.parseInt(numbers[i]);
        }

        System.out.println("Enter the nth largest element to be found: ");
        int n = s.nextInt();
        s.nextLine();

        s.close();

        System.out.println("Nth_Largest_Element_In_An_Array_Method_1: "
                + nth_Largest_Element_In_An_Array_Method_1(numbersArr, n));

        System.out.println("Nth_Largest_Element_In_An_Array_Method_2: "
                + nth_Largest_Element_In_An_Array_Method_2(numbersArr1, n));

    }

    private static int nth_Largest_Element_In_An_Array_Method_1(int[] numbersArr, int n)
    {
        // Time complexity: O(nLogn)
        // Space complexity: O(1)

        Arrays.sort(numbersArr);

        return numbersArr[numbersArr.length - n];
    }

    private static int nth_Largest_Element_In_An_Array_Method_2(int[] numbersArr, int n)
    {
        // Time complexity:O(nlogk)
        // Space complexity: O(k)

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(n + 1);
        // Not mandatory to specify Initial Capacity.

        for (int i : numbersArr)
        {
            priorityQueue.add(i);

            if (priorityQueue.size() > n)
                priorityQueue.poll();
        }
        return priorityQueue.poll();
    }
}
