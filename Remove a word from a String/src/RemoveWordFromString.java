import java.util.Scanner;

public class RemoveWordFromString {

    public static void main(String[] args) {

        // Question :

        // Find the letter present at the index and count the occurrence of that letter.
        // For example, occurrence is 3.
        // Remove the word present at 3rd index.
        // If word not present at that particular index, remove the last word from the string.

        // Sample input     : inputString = "Good Morning abc fgh hfg";
        // Sample input     : index = 2;

        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        int index = s.nextInt();
        s.close();

        String outputString = "";
        int count = 0;

        char charAtIndex = inputString.charAt(index);

        char charArray[] = inputString.toCharArray();

        for (char a : charArray) {
            if (a == charAtIndex) {
                count++;
            }
        }

        String words[] = inputString.split("\\s+");
        int wordsLen = words.length;

        if (count < words.length)
        {
            for (int i=0; i<words.length;i++)
            {
                if (i != count)
                {
                    outputString += words[i] + " ";
                }
            }
        }
        else
        {
            for (int i=0; i<words.length;i++)
            {
                if (i != wordsLen-1)
                {
                    outputString += words[i] + " ";
                }
            }
        }

        System.out.println(outputString);
    }
}
