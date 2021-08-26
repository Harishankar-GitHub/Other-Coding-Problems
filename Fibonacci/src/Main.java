import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int num = s.nextInt();
        System.out.println("Fibonacci of " + num + " is " + fibonacciValue(num));
        System.out.println("Fibonacci series : ");
        fibonacciSeries(num);
        System.out.println();
        System.out.println("Fibonacci series using Recursion : " + fibonacciValue_Using_Recursion(num));
    }

    static int fibonacciValue(int num)
    {
        if(num == 0) return 0;
        if(num == 1) return 1;

        int a = 0;
        int b = 1;
        int sum = 0;

        while (num > 1)
        {
            sum = a + b;
            a = b;
            b = sum;
            num --;
        }
        return sum;
    }

    static void fibonacciSeries(int count)
    {
        if(count == 0)
        {
            System.out.println("0");
        }
        else
        {
            int a = 0;
            int b = 1;
            int sum = 0;

            while(count != 0)
            {
                System.out.print(sum + " ");
                sum = a + b;
                a = b;
                b = sum;
                count--;
            }
        }
    }

    static int fibonacciValue_Using_Recursion(int num)
    {
        if(num == 0) return 0;
        if(num == 1) return 1;

        return fibonacciValue_Using_Recursion(num - 1) + fibonacciValue_Using_Recursion(num - 2);
    }
}