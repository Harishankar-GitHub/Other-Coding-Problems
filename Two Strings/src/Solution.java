import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Link : https://www.hackerrank.com/challenges/two-strings/problem

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        String yes = "YES";
        String no = "NO";

        for(char c : s1.toCharArray())
        {
            if(s1.indexOf(c) >= 0 && s2.indexOf(c) >= 0)
            {
                return yes;
            }
        }
        return no;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}