import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem:
    // https://www.hackerearth.com/problem/algorithm/beautiful-numbers-05de0f51-101121ca/

    public static void main(String[] args) {
        System.out.println("My Solution");

        System.out.println("Sum of Beautiful Numbers between 31, 32:  " + beautifulNumbers(31, 32));
        System.out.println("Sum of Beautiful Numbers between 1, 5:  " + beautifulNumbers(1, 5));

        System.out.println("Solution using Floyd's Cycle Finding Algorithm");

        System.out.println("Sum of Beautiful Numbers between 31, 32:  " + beautifulNumbers_solution_using_floyd_cycle_finding_algorithm(31, 32));
        System.out.println("Sum of Beautiful Numbers between 1, 5:  " + beautifulNumbers_solution_using_floyd_cycle_finding_algorithm(1, 5));
    }

    private static long beautifulNumbers(int l, int r) {
        long sumOfBeautifulNumbers = 0;
        int currentSumOfSquares;
        Set<Integer> sumOfSquares;

        for (int i = l; i <= r; i++) {
            sumOfSquares = new HashSet<>();
            int currentNum = i;
            while (true) {
                currentSumOfSquares = 0;
                while (currentNum > 0) {
                    currentSumOfSquares += (currentNum % 10) * (currentNum % 10);
                    currentNum = currentNum / 10;
                }

                if (currentSumOfSquares == 1) {
                    sumOfBeautifulNumbers += i;
                    break;
                }

                if (sumOfSquares.contains(currentSumOfSquares)) break;
                else sumOfSquares.add(currentSumOfSquares);

                currentNum = currentSumOfSquares;
            }
        }

        return sumOfBeautifulNumbers;
    }

    private static long beautifulNumbers_solution_using_floyd_cycle_finding_algorithm(int l, int r) {
        long sumOfBeautifulNumbers = 0;

        for (int currentNum = l; currentNum <= r; currentNum++) {
            int slowRunner = currentNum;
            int fastRunner = getNextNumber(currentNum);

            while (fastRunner != 1 && slowRunner != fastRunner) {
                slowRunner = getNextNumber(slowRunner);
                fastRunner = getNextNumber(getNextNumber(fastRunner));
            }

            if (fastRunner == 1) sumOfBeautifulNumbers += currentNum;
        }

        return sumOfBeautifulNumbers;
    }

    private static int getNextNumber(int number) {
        int totalSum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            totalSum += lastDigit * lastDigit;
            number = number / 10;
        }
        return totalSum;
    }
}
