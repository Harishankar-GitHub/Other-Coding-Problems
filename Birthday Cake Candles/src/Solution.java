import java.util.*;

public class Solution
{
//    Link: https://www.hackerrank.com/challenges/birthday-cake-candles/problem
//    Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter number of candles: ");
        int noOfCandles = s.nextInt();
        s.nextLine();

        List<Integer> candles = new ArrayList<>();

        for (int i = 0; i < noOfCandles; i++)
        {
            candles.add(s.nextInt());
            s.nextLine();
        }

        long start1 = System.currentTimeMillis();
        System.out.println("Count of tallest candles: " + birthdayCakeCandles(candles));
        long end1 = System.currentTimeMillis();
        System.out.println("Time taken for method 1: " + (end1 - start1));

        long start2 = System.currentTimeMillis();
        System.out.println("Another method - Count of tallest candles: " + birthdayCakeCandles_another_method(candles));
        long end2 = System.currentTimeMillis();
        System.out.println("Time taken for method 2: " + (end2 - start2));
    }

    public static int birthdayCakeCandles(List<Integer> candles) // This method is slow compared to another method.
    {
        int tallestCandles = 0;

        int max = candles.get(0);

        for (int candle : candles)
        {
            if (candle > max) max = candle;
        }

        for (int candle : candles)
        {
            if (candle == max)
            {
                tallestCandles++;
            }
        }
        return tallestCandles;
    }

    public static int birthdayCakeCandles_another_method(List<Integer> candles) // This method is faster.
    {
        candles.sort(Collections.reverseOrder());

        int tallestCandle = candles.get(0);

        int countOfTallestCandles = 0;

        for (int candle : candles)
        {
            if (candle == tallestCandle)
            {
                countOfTallestCandles++;
            }
        }
        return countOfTallestCandles;
    }
}
