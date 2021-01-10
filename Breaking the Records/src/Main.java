import java.util.Scanner;

public class Main
{

//    Link: https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
//    Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter the number of games played:");
        int numberOfGames = s.nextInt();
        s.nextLine();

        System.out.println("Enter " + numberOfGames + " scores:");

        int[] scores = new int[numberOfGames];

        for (int i = 0; i < numberOfGames; i++)
        {
            scores[i] = s.nextInt();
            s.nextLine();
        }

        int[] resultArr = breakingRecords(scores);

        for (int record : resultArr)
        {
            System.out.println(record);
        }
    }

    static int[] breakingRecords(int[] scores)
    {
        int[] resultArr = new int[2];

        int currentScore, minimumScore, maximumScore;
        currentScore = minimumScore = maximumScore = scores[0];

        for (int score : scores)
        {
            if (score != currentScore)
            {
                if (score > maximumScore)
                {
                    maximumScore = score;
                    resultArr[0]++;
                }
                else if (score < minimumScore)
                {
                    minimumScore = score;
                    resultArr[1]++;
                }
            }
            currentScore = score;
        }
        return resultArr;
    }
}
