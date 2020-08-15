import java.util.Scanner;

public class Main {

    // Link : https://www.hackerrank.com/challenges/java-string-tokens/problem

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        if(s.trim().length() == 0)
        {
            System.out.println("0");
            return;
        }
        if(s.length() > 400000)
        {
            return;
        }
        String delims = "[ @_.,?!']+";
        String[] tokens = s.trim().split(delims);
        System.out.println(tokens.length);
        for(String str : tokens)
        {
            System.out.println(str);
        }
        scan.close();
    }
}
