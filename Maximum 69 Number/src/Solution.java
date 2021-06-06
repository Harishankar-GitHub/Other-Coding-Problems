public class Solution
{
    // Problem statement: https://leetcode.com/problems/maximum-69-number/

    public static void main(String[] args)
    {
        int num = 9669;

        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number (int num)
    {
        char[] numArray = String.valueOf(num).toCharArray();

        for (int i = 0; i < numArray.length; i++)
        {
            if (numArray[i] == '6')
            {
                numArray[i] = '9';
                break;
            }
        }

        return Integer.parseInt(String.valueOf(numArray));
    }
}
