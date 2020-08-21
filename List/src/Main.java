import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//      Link : https://www.hackerrank.com/challenges/java-list/problem

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of elements in List : ");
        int n = s.nextInt();

        List<Integer> integerList = new ArrayList<>();
        for(int i = 0; i<n; i++)
        {
            System.out.println("Enter element #" + (i+1));
            int element = s.nextInt();
            integerList.add(element);
        }

        System.out.println("Enter number of queries : ");
        int q = s.nextInt();

        for(int i = 0; i<q; i++)
        {
            System.out.println("Enter query (Insert or Delete) : ");
            String queryString = s.next();
            if(queryString.equals("Insert"))
            {
                System.out.println("Position to insert : ");
                int position = s.nextInt();
                System.out.println("Element to be inserted : ");
                int element = s.nextInt();
                integerList.add(position,element);
            }
            else if(queryString.equals("Delete"))
            {
                System.out.println("Position of the element to be deleted : ");
                int position = s.nextInt();
                integerList.remove(position);
            }
        }

        for(Integer a : integerList)
        {
            System.out.print(a + " ");
        }
    }
}
