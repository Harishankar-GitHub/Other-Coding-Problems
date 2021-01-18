import java.util.Scanner;

public class Main
{
    // Problem statement: https://leetcode.com/problems/get-maximum-in-generated-array/
    // Solution: https://www.youtube.com/watch?v=UbqttH0rSBc

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter a number:");

        int n = s.nextInt();

        s.close();

        System.out.println(getMaximumGenerated(n));
    }

    private static int getMaximumGenerated(int n)
    {
        if (n < 2) return n;

        int[] numberArr = new int[n + 1];
        numberArr[1] = 1;
        int max = 0;

        for (int i = 2; i <= n; i++)
        {
            if (i % 2 == 0) numberArr[i] = numberArr[i / 2];
            else numberArr[i] = numberArr[i / 2] + numberArr[i / 2 + 1];

            max = Math.max(max, numberArr[i]);
        }
        return max;
    }
}
