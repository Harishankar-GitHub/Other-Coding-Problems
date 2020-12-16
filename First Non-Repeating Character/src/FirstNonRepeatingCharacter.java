import java.util.*;

public class FirstNonRepeatingCharacter
{
    // Problem: https://youtu.be/5co5Gvp_-S0

    // Sample input: aaabcccdeeef
    // Sample output: b
    // Explanation: a, c and e are repeating characters
    //              b, d, f are not repeating. Out of that b is first non repeating character.

    public static void main(String[] args)
    {
	    Scanner s = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String str = s.nextLine();
        s.close();

        // Method 1 ---------------------------------------------
        long start1 = System.currentTimeMillis();

        System.out.println(method1(str));

        long end1 = System.currentTimeMillis();
        System.out.println("Time taken for method 1: " + (end1 - start1));
        // Method 1 ---------------------------------------------

        // Method 2 ---------------------------------------------
        long start2 = System.currentTimeMillis();

        System.out.println(method2(str));

        long end2 = System.currentTimeMillis();
        System.out.println("Time taken for method 2: " + (end2 - start2));
        // Method 2 ---------------------------------------------

        // Method 3 ---------------------------------------------
        long start3 = System.currentTimeMillis();

        System.out.println(method3(str));

        long end3 = System.currentTimeMillis();
        System.out.println("Time taken for method 3: " + (end3 - start3));
        // Method 3 ---------------------------------------------

        
        // Faster to slower

        // Method 2 > Method 3 > Method 1
    }

    private static char method1(String str) // Using LinkedHashMap
    {
        Map<Character,Integer> charCountMap = new LinkedHashMap<>();

        for (char c : str.toCharArray())
        {
            if (charCountMap.containsKey(c))
            {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
            else
            {
                charCountMap.put(c, 1);
            }
        }

        for (char c : str.toCharArray())
        {
            if (charCountMap.get(c) == 1) return c;
        }
        return '_';
    }

    private static char method2(String str) // Using Array to store count of characters
    {
        char[] charCounts = new char[26];

        for (char c : str.toCharArray())
        {
            charCounts[c - 'a']++;
        }

        for (char c : str.toCharArray())
        {
            if (charCounts[c - 'a'] == 1) return c;
        }
        return '_';
    }

    private static char method3(String str) // Using built in method
    {
        for (char c : str.toCharArray())
        {
            if (str.indexOf(c) == str.lastIndexOf(c)) return c;
        }
        return '_';
    }
}
