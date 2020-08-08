import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        System.out.println("Enter number of elements : ");
        int numberOfElements = s.nextInt();
        s.nextLine();

        for(int i = 0; i < numberOfElements; i++)
        {
            System.out.println("Enter element " + (i+1) + " :");
            integerArrayList.add(s.nextInt());
            s.nextLine();
        }

        System.out.println("Enter the nth smallest element to be found : ");
        int k = s.nextInt();
        s.nextLine();

        ArrayList<Integer> uniqueArray = new ArrayList<>();

        for(int b : integerArrayList)
        {
            if(uniqueArray.contains(b))
            {
                continue;
            }
            else
            {
                uniqueArray.add(b);
            }
        }

        Collections.sort(uniqueArray);

//        for(int a : uniqueArray)
//        {
//            System.out.print(a + ", ");
//        }

        if(uniqueArray.size() >= k)
        {
            System.out.println("\nNth smallest element in an array is " + uniqueArray.get(k-1));
        }
        else
        {
            System.out.println("Null");
        }

    }
}