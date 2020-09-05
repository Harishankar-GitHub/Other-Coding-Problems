import java.util.Scanner;

public class Solution {

    // Link : https://www.hackerrank.com/challenges/java-negative-subarray/problem

//      Problem Statement
//      Sample input :
//      number of elements : 5
//      elements :   1
//                  -2
//                   4
//                  -5
//                   1

//    sub arrays are 1, -2, 4, -5, 1, {1,-2}, {1,-2,4}.. etc etc
//    Sample output : 9
//    Explanation : There are 9 sub arrays in given array


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i<n; i++)
        {
            arr[i] = s.nextInt();
        }

        s.close();

        int negativeSubArraysCount = 0;

        for(int i = 0; i<n; i++)
        {
            for(int j = i; j<n; j++)
            {
                int sum = 0;
                for(int k = i; k <= j; k++)
                {
                    sum += arr[k];
                }
                if(sum < 0)
                {
                    negativeSubArraysCount++;
                }
            }
        }
        System.out.println(negativeSubArraysCount);
    }
}