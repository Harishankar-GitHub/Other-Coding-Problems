import java.util.Scanner;

public class Main {

//    Link : https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

    public static void main(String[] args) {

        Scanner s = new Scanner((System.in));
        System.out.println("Enter number of elements : ");
        int n = s.nextInt();
        System.out.println("Enter number of rotations : ");
        int d = s.nextInt();
        System.out.println("Enter elements : ");
        int[] a = new int[n];

        for(int i=0; i<n; i++)
        {
            System.out.println("Enter a number : ");
            a[i] = s.nextInt();
        }

        int[] result = rotLeft(a, d);
        for(int i=0; i<n; i++)
        {
            System.out.print(result[i] + " ");
        }
    }

    static int[] rotLeft(int[] a, int d) {
        int n = a.length;
        int[] rotatedArray = new int[n];

        int i = 0;
        int rotateIndex = d;

        while(rotateIndex < n)
        {
            rotatedArray[i] = a[rotateIndex];
            i++;
            rotateIndex++;
        }

        rotateIndex = 0;

        while (rotateIndex < d)
        {
            rotatedArray[i] = a[rotateIndex];
            i++;
            rotateIndex++;
        }

        return rotatedArray;
    }
}
