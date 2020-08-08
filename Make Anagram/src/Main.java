import java.util.Scanner;

public class Main {

    // Link : https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

    private static Scanner s = new Scanner(System.in);


    public static void main(String[] args) {

        // Sample Input :
        // String 1 : cde
        // String 2 : abc
        System.out.println("Enter 1st string : ");
        String aStr = s.nextLine();
        System.out.println("Enter 2nd string : ");
        String bStr = s.nextLine();
        System.out.println(makeAnagram(aStr,bStr));
    }

    public static int makeAnagram(String a, String b)
    {
        int minimum_deletions = 0;

        int[] a_frequencies = new int[26]; // (0,0,1,1,1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)
        int[] b_frequencies = new int[26]; // (1,1,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0)

        for(int i=0; i < a.length(); i++)
        {
            char current_char = a.charAt(i);
            int char_to_int = (int) current_char;                       // 99
//            System.out.println("char_to_int" + char_to_int);
            int position = char_to_int - (int) 'a';                     // 99 - 97 = 2
//            System.out.println("(int) 'a' " + (int) 'a');
            a_frequencies[position] = a_frequencies[position] + 1;
        }

        for(int i=0; i < b.length(); i++)
        {
            char current_char = b.charAt(i);
            int char_to_int = (int) current_char;
            int position = char_to_int - (int) 'a';
            b_frequencies[position] = b_frequencies[position] + 1;
        }

        for(int i = 0; i < 26; i++)
        {
            int difference = Math.abs(a_frequencies[i] - b_frequencies[i]);
            minimum_deletions += difference;
        }
        return minimum_deletions;
    }
}
