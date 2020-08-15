import java.util.*;

public class Main {

    //      Link : https://www.hackerrank.com/challenges/sherlock-and-valid-string/problem

    public static void main(String[] args) {


        // Sample input : aabbccccc
        // Sample output : NO

        // All occurrences of characters in the string should be same.
        // If it is not same, we can remove only 1 occurrence of a character to make it valid.
        // For example : aabbccc
        // Here we can remove 1 occurrence of c to make string aabbcc which satisfies the condition

        Scanner s = new Scanner(System.in);
        System.out.println("Enter string : ");
        String str = s.nextLine();
        System.out.println(isValid(str));
    }

    public static String isValid(String s)
    {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray())
        {
            if(map.containsKey(c))
            {
                map.put(c,map.get(c) + 1);
            }
            else
            {
                map.put(c,1);
            }
        }

       List<Integer> frequencies = new ArrayList<>();
       int count = 0;
       for(int a : map.values())
       {
           if(a == 1)
           {
               count++;
           }
           frequencies.add(a);
       }

//        for(int a : frequencies)
//        {
//            System.out.println(a);
//        }

       if(isAllSame(frequencies))
       {
           return "YES";
       }

       if(count == 1)
       {
           int element = 0;

           for (int frequency : frequencies)
           {
               if (frequency != 1)
               {
                   element = frequency;
                   break;
               }
           }

           for(int a : frequencies)
           {
               if(a != 1 && a != element)
               {
                   return "NO";
               }
           }
           return "YES";
       }

       for(int i = 0; i<frequencies.size(); i++)
       {
            frequencies.set(i,frequencies.get(i)-1);    // Checking if it is equal by decreasing frequency by 1.

            if(isAllSame(frequencies))
            {
                return "YES";
            }
            else
            {
                frequencies.set(i, frequencies.get(i)+1);
            }
       }
        return "NO";
    }

    public static boolean isAllSame(List<Integer> intList)
    {
        int firstElement = intList.get(0);

        for(int a : intList)
        {
            if(a != firstElement)
            {
                return false;
            }
        }
        return true;
    }
}