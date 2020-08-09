import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Link : https://www.hackerrank.com/challenges/java-arraylist/problem

        // Sample input
        // 5 - No. of arrays

        // 3    1 5 9   // First number is No. of elements
        // 4    9 8 7 5
        // 2    1 2
        // 6    3 2 1 4 5 8
        // 5    1 2 3 4 5

        // After this
        // 2 - No. of queries
        // 1 3  // First number is the nth arraylist from above arraylist, 2nd number is position
        // 4 4


        Scanner s = new Scanner(System.in);
        System.out.print("Enter No. of ArrayLists : ");
        int n = s.nextInt();
        ArrayList[] arr = new ArrayList[n];

        for(int i = 0; i<n; i++)
        {
            System.out.print("Enter the number of elements in arraylist : " + (i+1) + "\n");
            int d = s.nextInt();
            arr[i] = new ArrayList();
            System.out.println("Enter " + d + " elements : ");
            for(int j = 0; j<d; j++)
            {
                arr[i].add(s.nextInt());
            }
        }

        System.out.println("Enter number of queries : ");
        int x = s.nextInt();
        for(int i = 0; i<x; i++)
        {
            System.out.println("Enter query " + (i+1));
            System.out.println("For example : 1 4 to fetch 4th element from 1st array !");
            int a = s.nextInt();
            int b = s.nextInt();
            try{
                System.out.println(arr[a-1].get(b-1));
            }
            catch(Exception e)
            {
                System.out.println("ERROR!");
            }
        }
    }
}
