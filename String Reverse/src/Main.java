import java.util.Scanner;

public class Main {

    // Link : https://www.hackerrank.com/challenges/java-string-reverse/problem

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String A=sc.next();

        // Method 1

        // char[] charArray = A.toCharArray();
        // int length = charArray.length;
        // String reverse = "";

        // for(int i=length; i>0; i--)
        // {
        //     reverse += charArray[i-1];
        // }
        // if(reverse.equals(A))
        // {
        //     System.out.println("Yes");
        // }
        // else
        // {
        //     System.out.println("No");
        // }

        // Method 2

//        String B = new StringBuilder(A).reverse().toString();
//        if(A.equals(B))
//        {
//            System.out.println("Yes");
//        }
//        else
//        {
//            System.out.println("No");
//        }

        // Method 3
        int a = 0;
        int b = A.length() - 1;

        while(a < b) // a<b will also work
        {
            if(A.charAt(a) != A.charAt(b))
            {
                System.out.println("No");
                return;
            }
            a++;
            b--;
        }
        System.out.println("Yes");
    }
}
