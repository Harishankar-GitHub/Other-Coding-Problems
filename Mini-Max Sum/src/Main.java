import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Scanner;

public class Main
{
    // Link: https://www.hackerrank.com/challenges/mini-max-sum/problem
    // Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter 5 integers:");

        int[] arr = new int[5];

        for (int i = 0; i < 5; i++)
        {
            arr[i] = s.nextInt();
            s.nextLine();
        }

        s.close();

        long start1 = System.currentTimeMillis();
        miniMaxSum(arr);
        long end1 = System.currentTimeMillis();
        System.out.println("Time taken for miniMaxSum(): " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        miniMaxSum_another_method(arr);
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken for miniMaxSum_another_method(): " + (end2 - start2));
    }

    static void miniMaxSum(int[] arr)   // This is faster.
    {
        long sum = 0;
        long max = arr[0];
        long min = arr[0];

        for (int number : arr)
        {
            sum += number;
            if (number > max) max = number;
            if (number < min) min = number;
        }

        System.out.println((sum - max) + " " + (sum - min));
    }

    static void miniMaxSum_another_method(int[] arr)
    {
        Arrays.sort(arr);

        long min = 0, max = 0;

        for(int i = 0, j = arr.length - 1; i < arr.length - 1; i++, j--)
        {
            max = max + arr[j];
            min = min + arr[i];
        }

        System.out.println(min + " " + max);
    }
}
