import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

    // Link : https://www.hackerrank.com/challenges/java-anagrams/problem

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter 1st String : ");
        String a = s.nextLine();
        System.out.println("Enter 2nd String : ");
        String b = s.nextLine();
        if(isAnagram(a,b))
        {
            System.out.println(a + " and " + b + " are Anagrams !");
        }
        else
        {
            System.out.println(a + " and " + b + " are not Anagrams !");
        }

    }

    public static boolean isAnagram(String a, String b)
    {

        char[] aChar = a.toLowerCase().toCharArray();
        char[] bChar = b.toLowerCase().toCharArray();

        Arrays.sort(aChar);
        Arrays.sort(bChar);

        return Arrays.equals(aChar, bChar);
    }
}
