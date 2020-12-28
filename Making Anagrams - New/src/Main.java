import java.util.Scanner;

public class Main
{
    // Link: https://www.hackerrank.com/challenges/making-anagrams/problem

    // Sample Input:
    // String 1 : cde
    // String 2 : abc

    // Sample output:
    // 4

    // Explanation:

    //    We delete the following characters from our two strings to turn them into anagrams of each other:
    //
    //    Remove d and e from cde to get c.
    //    Remove a and b from abc to get c.
    //    We had to delete characters to make both strings anagrams.

    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter a string:");
        String s1 = s.nextLine();

        System.out.println("Enter another string:");
        String s2 = s.nextLine();

        s.close();

        System.out.println("Minimum deletions required to make Anagram: " + makingAnagrams(s1, s2));

    }

    static int makingAnagrams(String s1, String s2)
    {
        int minimum_deletions = 0;

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        for (char c : s1.toCharArray())
        {
            s1Count[c - 'a']++;
        }

        for (char c : s2.toCharArray())
        {
            s2Count[c - 'a']++;
        }

        for (int i = 0; i < s1Count.length; i++)
        {
            minimum_deletions += Math.abs(s1Count[i] - s2Count[i]);
        }

        return minimum_deletions;
    }
}
