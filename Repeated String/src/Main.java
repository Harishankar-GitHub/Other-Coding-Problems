import java.util.Scanner;

public class Main {

    // Link : https://www.hackerrank.com/challenges/repeated-string/problem

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string : ");
        String str = scanner.nextLine();
        System.out.println("Enter a number to find count of 'a' in first n letters : ");
        long n = scanner.nextLong();

        System.out.println(repeatedString(str, n));
    }

    static long repeatedString(String s, long n) {
        long count = 0;
        int strLength = s.length();

        if (!s.contains("a")) return 0;

        if (strLength == 1)
        {
            count = n;
            return count;
        }

        if (strLength < n)
        {
            long a = n / s.length();
            long modVal = n % s.length();
            for(int i = 0; i < s.length(); i++)
            {
                if(s.charAt(i) == 'a')
                {
                    count += 1;
                }
            }
            count = a * count;
            for(int i = 0; i < modVal; i++)
            {
                if(s.charAt(i) == 'a')
                {
                    count += 1;
                }
            }
            return count;
        }
        else if(n == s.length())
        {
            for (int i = 0; i < s.length(); i++)
            {
                if (s.charAt(i) == 'a')
                {
                    count++;
                }
            }
        }
        else if(strLength > n)
        {
            for (int i = 0; i < n; i++)
            {
                if (s.charAt(i) == 'a')
                {
                    count++;
                }
            }
        }
        return count;
    }
}