import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
//    Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter 26 space separated values for heights of letters:");

        String[] inputHeightOfLetters = s.nextLine().split(" ");
        int[] heights = new int[26];

        for (int i = 0; i < inputHeightOfLetters.length; i++)
        {
            heights[i] = Integer.parseInt(inputHeightOfLetters[i]);
        }

        System.out.println("Enter a word:");
        String word = s.nextLine();

        s.close();

        System.out.println(designerPdfViewer(heights, word));
    }

    static int designerPdfViewer(int[] h, String word)
    {
        int wordLength = word.length();
        int maxHeight = 0;

        if (wordLength <= 10)
        {
            for (char s : word.toCharArray())
            {
                int ascii = s - 'a';

                if (h[ascii] > maxHeight)
                    maxHeight = h[ascii];
            }
        }
        return maxHeight * wordLength;
    }
}
