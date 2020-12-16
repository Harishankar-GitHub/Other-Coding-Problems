import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {

        // Problem: https://youtu.be/a_3XDW9P47E
        
        // Program to find the length of longest palindrome that can be formed from
        // given string

        // Sample input     : abccccdd          1,1,3,2     length += 5 / 2 * 2 = 4
        // Sample output    : 7
        // Explanation      : dccaccd


        Scanner s = new Scanner(System.in);

        System.out.println("Enter a string : ");
        String str = s.nextLine();

        System.out.println(lengthOfLongestPalindrome(str));

    }

    private static int lengthOfLongestPalindrome(String str)
    {
        int length = 0;

        int[] char_count = new int[26];

        for (char c : str.replace(" ", "").toLowerCase().toCharArray())
        {
            int position = (int) c - (int) 'a';     // position = 99 - 97 = 2
            char_count[position]++;
        }

        for (int count : char_count)
        {
            length += count / 2 * 2;

            if (length % 2 == 0 && count % 2 == 1)
            {
                length++;
            }
        }

        return length;
    }
}