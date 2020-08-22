import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//      Link : https://www.hackerrank.com/challenges/java-hashset/problem

public class Main {

    // Sample input :
    // 5
    // john tom
    // john mary
    // john tom
    // mary anna
    // mary anna

    // We have to find the count of unique pairs after each input pair.

    // Sample output :
    // 1
    // 2
    // 2
    // 3
    // 3

    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];

        for (int i = 0; i < t; i++) {
            pair_left[i] = s.next();
            pair_right[i] = s.next();
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < t; i++)
        {
            set.add(pair_left[i] + " " + pair_right[i]);
            System.out.println(set.size());
        }
    }
}
