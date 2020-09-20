import java.util.Scanner;
import java.util.regex.*;

public class Solution
{
//     Link : https://www.hackerrank.com/challenges/pattern-syntax-checker/problem

//     Sample input :
//     3
//     ([A-Z])(.+)
//     [AZ[a-z](a-z)
//     batcatpat(nat

//    Sample output :
//    Valid
//    Invalid
//    Invalid

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            try
            {
                Pattern.compile(pattern);
                System.out.println("Valid");
            }
            catch(Exception e)
            {
                System.out.println("Invalid");
            }
            testCases--;
        }
    }
}