import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Link : https://www.hackerrank.com/challenges/alternating-characters/problem

        // Problem statement : Need to find the minimum number of deletions required to
        // make the characters alternative in the string.
        // Example : s = AABAAB -> remove an A at positions 0 and 3 to make s = ABAB in 2 deletions.
        // AAAA -> 3 deletions -> A
        // ABABABAB -> 0 deletions -> ABABABAB
        // AAABBB -> 4 deletions -> AB

        Scanner s = new Scanner(System.in);
        System.out.println("Enter string : ");
        String str = s.nextLine();
        System.out.println("Minimum deletions : " + alternatingCharacters(str));

    }

    public static int alternatingCharacters(String s)
    {
        int minimum_deletions = 0;

        for(int i = 0; i<s.length()-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                minimum_deletions += 1;
            }
        }
        return minimum_deletions;
    }
}
