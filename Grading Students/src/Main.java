import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
//    Link: https://www.hackerrank.com/challenges/grading/problem
//    Problem statement attached in project folder.

    private static final Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Enter number of grades: ");
        int numberOfGrades = s.nextInt();
        s.nextLine();

        List<Integer> gradesList = new ArrayList<>();

        System.out.println("Enter " + numberOfGrades + " grades:");
        for (int i = 0; i < numberOfGrades; i++)
        {
            gradesList.add(s.nextInt());
            s.nextLine();
        }

        s.close();

        long start1 = System.currentTimeMillis();
        List<Integer> resultList1 = gradingStudents(gradesList);
        long end1 = System.currentTimeMillis();

        long start2 = System.currentTimeMillis();
        List<Integer> resultList2 = gradingStudents_another_method(gradesList);
        long end2 = System.currentTimeMillis();

        for (int grade : resultList1)
        {
            System.out.println(grade);
        }

        for (int grade : resultList2)
        {
            System.out.println(grade);
        }

        System.out.println("Time taken for method 1: " + (end1 - start1));
        System.out.println("Time taken for method 2: " + (end2 - start2));
    }

    public static List<Integer> gradingStudents(List<Integer> grades)   // This is faster.
    {
        List<Integer> resultList = new ArrayList<>();

        for (int grade : grades)
        {
            if (grade % 5 != 0 && grade >= 38)
            {
                if ((grade + 1) % 5 == 0) resultList.add(grade + 1);
                else if ((grade + 2) % 5 == 0) resultList.add(grade + 2);
                else resultList.add(grade);
            }
            else
            {
                resultList.add(grade);
            }
        }
        return resultList;
    }

    public static List<Integer> gradingStudents_another_method(List<Integer> grades)
    {
        List<Integer> resultList = new ArrayList<>();

        for (int grade : grades)
        {
            if (grade >= 38)
            {
                if (grade % 5 == 3) resultList.add(grade + 2);
                else if (grade % 5 == 4) resultList.add(grade + 1);
                else resultList.add(grade);
            }
            else
            {
                resultList.add(grade);
            }
        }

        return resultList;
    }
}
