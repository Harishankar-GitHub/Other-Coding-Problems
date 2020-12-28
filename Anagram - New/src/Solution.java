import java.io.IOException;
import java.util.*;

public class Solution
{

//    Link: https://www.hackerrank.com/challenges/anagram/problem

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException
    {
        String s = scanner.nextLine();

// ***********  Method 1  ***********

        long start1 = System.currentTimeMillis();

        System.out.println(Solution.anagram(s));

        long end1 = System.currentTimeMillis();
        System.out.println("Time taken for method 1: " + (end1 - start1));

// ***********  Method 1  ***********

// ***********  My method  ***********

        long start2 = System.currentTimeMillis();

        System.out.println(Solution.anagram_my_method(s));

        long end2 = System.currentTimeMillis();
        System.out.println("Time taken for method 2: " + (end2 - start2));

// ***********  My method  ***********

        scanner.close();
    }

    private static int anagram(String s)    // This solution from Hackerrank Discussion Forum.
    {
        int stringLength = s.length();
        if (stringLength % 2 != 0) return -1;

        String s1 = s.substring(0, stringLength / 2);
        String s2 = s.substring(stringLength / 2);

        int count = 0;

        for (char c : s1.toCharArray())
        {
            int index = s2.indexOf(c);
            if (index == -1)
            {
                count++;
            }
            else
            {
                s2 = s2.substring(0, index) + s2.substring(index + 1);
            }
        }
        return count;
    }

    private static int anagram_my_method(String s) // This is my own solution.
    {
        int count = 0;

        int stringLength = s.length();

        if (stringLength % 2 != 0) return -1;

        String s1 = s.substring(0, stringLength / 2);
        String s2 = s.substring(stringLength / 2);

        int[] s1Arr = new int[26];
        int[] s2Arr = new int[26];

        for (int i = 0; i < s1.length(); i++)
        {
            s2Arr[s2.charAt(i) - 'a']++;
            s1Arr[s1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s1Arr.length; i++)
        {
            if (s2Arr[i] != 0 && s1Arr[i] <= s2Arr[i])
            {
                count += Math.abs(s2Arr[i] - s1Arr[i]);
            }
        }

//        System.out.println("S1 Array :");
//        for (int c : s1Arr)
//        {
//            System.out.print(c + " ");
//        }
//
//        System.out.println();
//
//        System.out.println("S2 Array :");
//        for (int c : s2Arr)
//        {
//            System.out.print(c + " ");
//        }

        return count;
    }
}

// Sample input:

//        6
//        aaabbb
//        ab
//        abc
//        mnop
//        xyyx
//        xaxbbbxx

// Sample output:

//        3
//        1
//        -1
//        2
//        0
//        1

// Explanation
//
//        Test Case #01: We split  into two strings ='aaa' and ='bbb'. We have to replace all three characters from the first string with 'b' to make the strings anagrams.
//
//        Test Case #02: You have to replace 'a' with 'b', which will generate "bb".
//
//        Test Case #03: It is not possible for two strings of unequal length to be anagrams of one another.
//
//        Test Case #04: We have to replace both the characters of first string ("mn") to make it an anagram of the other one.
//
//        Test Case #05:  and  are already anagrams of one another.
//
//        Test Case #06: Here S1 = "xaxb" and S2 = "bbxx". You must replace 'a' from S1 with 'b' so that S1 = "xbxb".