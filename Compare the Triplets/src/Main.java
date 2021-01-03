import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/compare-the-triplets/problem

//    Sample input:

//    1,2,3 -> Alice's Rating
//    3,2,1 -> Bob's Rating

//    Sample output:

//    1,1

//    Explanation:

//  If Alice's Rating > Bob's rating Then Alice gets 1 point.
//  If Bob's Rating > Alice's Rating Then Bob gets 1 point.

//    So, for a[0], b[0] -> Bob gets 1 point.
//    a[1], b[1] -> Neither receives point.
//    a[2], b[2] -> Alice gets 1 point.

//    Result list: Alice's point, Bob's point.
//              So, 1,1 is result list.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        List<Integer> alice_Rating_List = new ArrayList<>();
        List<Integer> bob_Rating_List = new ArrayList<>();

        System.out.println("Enter Alice's ratings:");

        for (int i = 0; i < 3; i++)
        {
            alice_Rating_List.add(s.nextInt());
            s.nextLine();
        }

        System.out.println("Enter Bob's ratings:");

        for (int i = 0; i < 3; i++)
        {
            bob_Rating_List.add(s.nextInt());
            s.nextLine();
        }

        List<Integer> result = compareTriplets(alice_Rating_List, bob_Rating_List);

        for (int rating : result)
        {
            System.out.print(rating + " ");
        }
    }

    static List<Integer> compareTriplets(List<Integer> a, List<Integer> b)
    {
//        List<Integer> result = new ArrayList<>();
//        int alice_rating = 0;
//        int bob_rating = 0;
//
//        for (int i = 0; i < a.size(); i++)
//        {
//            if (a.get(i) > b.get(i)) alice_rating += 1;
//            else if (a.get(i) < b.get(i)) bob_rating += 1;
//        }
//        result.add(alice_rating);
//        result.add(bob_rating);
//        return result;

        List<Integer> result = new ArrayList<>();

        int alice_rating = ((a.get(0) > b.get(0)) ? 1 : 0) + ((a.get(1) > b.get(1)) ? 1 : 0) + ((a.get(2) > b.get(2)) ? 1 : 0);
        int bob_rating = ((b.get(0) > a.get(0)) ? 1 : 0) + ((b.get(1) > a.get(1)) ? 1 : 0) + ((b.get(2) > a.get(2)) ? 1 : 0);

        result.add(alice_rating);
        result.add(bob_rating);

        return result;

    }
}
