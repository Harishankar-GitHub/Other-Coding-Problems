import java.util.Scanner;

public class Main
{
    // Link: https://www.hackerrank.com/challenges/palindrome-index/problem

    // Sample input:
    //  aaab
    //  baa
    //  aaa

    // Sample output:
    //  3
    //  0
    // -1

    // Explanation:

//    Query 1: "aaab"
//    Removing 'b' at index 3 results in a palindrome, so return 3.
//
//    Query 2: "baa"
//    Removing 'b' at index 0 results in a palindrome, so return 0.
//
//    Query 3: "aaa"
//    This string is already a palindrome, so return -1.
//    Removing any one of the characters would result in a palindrome, but this test comes first.

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter a string:");
        String str = s.nextLine();

        System.out.println(palindromeIndex(str));

    }

    static int palindromeIndex(String s)
    {
        if (s.length() <= 2) return -1;

        int start = 0;
        int end = s.length() - 1;

        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                if (checkPalindrome(s, start + 1, end))
                {
                    return start;
                }
                else if (checkPalindrome(s, start, end - 1))
                {
                    return end;
                }
            }
            start++;
            end--;
        }
        return -1;
    }

    private static boolean checkPalindrome(String s, int start, int end)
    {
        while (start < end)
        {
            if (s.charAt(start) != s.charAt(end))
            {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
