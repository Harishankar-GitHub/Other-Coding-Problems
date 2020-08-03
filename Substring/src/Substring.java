import java.util.*;

public class Substring {

    public static void main(String[] args)
    {

        // Link : https://www.hackerrank.com/challenges/java-string-compare/problem

        // Problem Statement :
        // String s = "welcometojava" has the following lexicographically-ordered substrings of length : k=3
        // ava, com, elc, eto, jav, lco, met, oja, ome, toj, wel
        // We then return the first (lexicographically smallest) substring
        // and the last (lexicographically largest) substring as two newline-separated values (i.e., ava\nwel).
        //***********************************************************************************************

        // Explanation :
        // We have to extract substrings of length 3. like wel, com, eto etc.
        // Sort it.
        // Return 1st & last value.
        //***********************************************************************************************



        // Method 1
//            String s = "welcometojava";
////            String s = "HiHelloHowAreYou";
////            String s = "zabhjudhiabc";
//
//        int k = 3;
//        k -= 1;


//            List<String> list1 = new ArrayList<>();
//
//            for (int i = 0; i<s.length()-k; i++)
//            {
//                list1.add(s.substring(i, i + k+1));
//            }
//
//            Collections.sort(list1);
//            String smallest = list1.get(0);
//            String largest = list1.get(list1.size()-1);
//
//        System.out.println(smallest + " " + largest);



        // Method 2
        String s = "welcometojava";
//            String s = "HiHelloHowAreYou";
//            String s = "zabhjudhiabc";

        int k = 3;
        k -= 1;

        SortedSet<String> sortedSet = new TreeSet<String>();

        for (int i = 0; i<s.length()-k; i++)
        {
            sortedSet.add(s.substring(i,i+k+1));
        }

        System.out.println(sortedSet.toString());

        String smallest = sortedSet.first();
        String largest = sortedSet.last();

        System.out.println(smallest + " " + largest);
    }
}