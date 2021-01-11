import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/apple-and-orange/problem
//    Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter Sam's house starting point and ending point (Space separated): ");
        String[] startingAndEndingOfSamHouse = s.nextLine().split(" ");

        int starting = Integer.parseInt(startingAndEndingOfSamHouse[0]);
        int ending = Integer.parseInt(startingAndEndingOfSamHouse[1]);

        System.out.println("Enter location of Apple and Orange tree (Space separated): ");
        String[] locationOfAppleandOrangeTree = s.nextLine().split(" ");

        int locationOfApple = Integer.parseInt(locationOfAppleandOrangeTree[0]);
        int locationOfOrange = Integer.parseInt(locationOfAppleandOrangeTree[1]);

        System.out.println("Enter number of Apples and Oranges (Space separated): ");
        String[] numberOfApplesAndOranges = s.nextLine().split(" ");

        int numberOfApples = Integer.parseInt(numberOfApplesAndOranges[0]);
        int numberOfOranges = Integer.parseInt(numberOfApplesAndOranges[1]);

        int[] appleDistanceArr = new int[numberOfApples];

        System.out.println("Enter distances at which each apple falls from the tree (Space separated): ");
        String[] distanceOfApples = s.nextLine().split(" ");

        for (int i = 0; i < numberOfApples; i++)
        {
            appleDistanceArr[i] = Integer.parseInt(distanceOfApples[i]);
        }

        int[] orangeDistanceArr = new int[numberOfApples];

        System.out.println("Enter distances at which each orange fall from the tree: ");
        String[] distanceOfOranges = s.nextLine().split(" ");

        for (int i = 0; i < numberOfOranges; i++)
        {
            orangeDistanceArr[i] = Integer.parseInt(distanceOfOranges[i]);
        }

        countApplesAndOranges(starting, ending, locationOfApple, locationOfOrange, appleDistanceArr, orangeDistanceArr);


    }

    static void countApplesAndOranges(int starting, int ending, int locationOfApple,
         int locationOfOrange, int[] appleDistanceArr, int[] orangeDistanceArr)
    {
        int appleResult = 0;
        int orangeResult = 0;

        for (int appleDistance : appleDistanceArr)
        {
            appleResult += checkPositionAndIncrementResult(starting, ending, locationOfApple, appleDistance);
        }

        for (int orangeDistance : orangeDistanceArr)
        {
            orangeResult += checkPositionAndIncrementResult(starting, ending, locationOfOrange, orangeDistance);
        }

        System.out.println(appleResult);
        System.out.println(orangeResult);
    }

    private static int checkPositionAndIncrementResult
        (int starting, int ending, int locationOfAppleOrOrange, int distanceOfAppleOrOrange)
    {
        int position = locationOfAppleOrOrange + distanceOfAppleOrOrange;

        if (position >= starting && position <= ending)
            return 1;
        return 0;
    }
}
