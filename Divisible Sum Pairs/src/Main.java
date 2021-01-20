import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
//    Problem statement attached in project folder

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter number of elements and k value (Space separated):");
        String[] inputValues = s.nextLine().split(" ");

        int numberOfValues = Integer.parseInt(inputValues[0]);
        int valueOfK = Integer.parseInt(inputValues[1]);

        System.out.println("Enter " + numberOfValues + " numbers (Space separated):");
        String[] arrayElements = s.nextLine().split(" ");

        int[] numberArr = new int[numberOfValues];

        for (int i = 0; i < numberOfValues; i++)
        {
            numberArr[i] = Integer.parseInt(arrayElements[i]);
        }


        System.out.println(divisibleSumPairs(numberOfValues, valueOfK, numberArr));

    }

    static int divisibleSumPairs(int n, int k, int[] ar)
    {
        int count = 0;

        for (int i = 0; i < n-1; i++)
        {
            for (int j = i+1; j < n; j++)
            {
                if ((ar[i] + ar[j]) % k == 0) count++;
            }
        }

        return count;
    }
}
