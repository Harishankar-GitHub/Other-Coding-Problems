import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/funny-string/problem
//    Problem statement attached in project folder

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter number of strings: ");
        int count = s.nextInt();
        s.nextLine();

        System.out.println("Enter " + count + " strings:");

        for (int i = 0; i < count; i++)
        {
            String input = s.nextLine();
            long start1 = System.currentTimeMillis();
            System.out.println(funnyString(input));
            long end1 = System.currentTimeMillis();
            System.out.println("Time taken for method 1: " + (end1 - start1));

            long start2 = System.currentTimeMillis();
            System.out.println(funnyString_another_method(input));
            long end2 = System.currentTimeMillis();
            System.out.println("Time taken for method 2: " + (end2 - start2));
        }

        s.close();
    }

    static String funnyString(String s) // My method is faster
    {
        int length = s.length();
        int[] asciiValueArr = new int[length];
        int[] reverseAsciiValueArr = new int[length];

        for (int i = 0; i < length - 1; i++)
        {
            int asciiValue = s.charAt(i);
            asciiValueArr[i] = asciiValue;
            reverseAsciiValueArr[length - i - 1] = asciiValue;
        }

        for (int i = 0; i < length - 1; i++)
        {
            int asciiDifference = Math.abs(asciiValueArr[i] - asciiValueArr[i+1]);
            int reverseAsciiDifference = Math.abs(reverseAsciiValueArr[i] - reverseAsciiValueArr[i+1]);

            if (asciiDifference != reverseAsciiDifference)
            {
                return "Not Funny";
            }
        }

        return "Funny";
    }

    static String funnyString_another_method(String s)
    {
        char[] arr = s.toCharArray();
        char[] reverseArr = new StringBuilder(s).reverse().toString().toCharArray();

        for (int i = 0; i < s.length() - 1; i++)
        {
            if ((Math.abs((int) arr[i] - (int) arr[i+1])) != (Math.abs((int) reverseArr[i] - (int) reverseArr[i+1])))
            {
                return "Not Funny";
            }
        }
        return "Funny";
    }
}
