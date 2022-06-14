import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem:
    // https://leetcode.com/problems/happy-number/

    public static void main(String[] args) {
        System.out.println("Solution 1");

        System.out.println("Is 32 a Happy Number? " + isHappy_solution_1(32));
        System.out.println("Is 31 a Happy Number? " + isHappy_solution_1(31));
        System.out.println("Is 7 a Happy Number? " + isHappy_solution_1(7));
        System.out.println("Is 2 a Happy Number? " + isHappy_solution_1(2));
        System.out.println("Is 1 a Happy Number? " + isHappy_solution_1(1));
        System.out.println("Is 63 a Happy Number? " + isHappy_solution_1(63));
        System.out.println("Is 19 a Happy Number? " + isHappy_solution_1(19));

        System.out.println("Solution 2");

        System.out.println("Is 32 a Happy Number? " + isHappy_solution_2(32));
        System.out.println("Is 31 a Happy Number? " + isHappy_solution_2(31));
        System.out.println("Is 7 a Happy Number? " + isHappy_solution_2(7));
        System.out.println("Is 2 a Happy Number? " + isHappy_solution_2(2));
        System.out.println("Is 1 a Happy Number? " + isHappy_solution_2(1));
        System.out.println("Is 63 a Happy Number? " + isHappy_solution_2(63));
        System.out.println("Is 19 a Happy Number? " + isHappy_solution_2(19));

        System.out.println("Solution 3");

        System.out.println("Is 32 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(32));
        System.out.println("Is 31 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(31));
        System.out.println("Is 7 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(7));
        System.out.println("Is 2 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(2));
        System.out.println("Is 1 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(1));
        System.out.println("Is 63 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(63));
        System.out.println("Is 19 a Happy Number? " + isHappy_solution_using_floyd_cycle_finding_algorithm(19));
    }

    private static boolean isHappy_solution_1(int number) {
        int currentSumOfSquares;
        Set<Integer> sumOfSquaresAlreadySeen = new HashSet<>();

        while (true) {
            currentSumOfSquares = getNextNumber(number);

            if (currentSumOfSquares == 1) return true;
            if (sumOfSquaresAlreadySeen.contains(currentSumOfSquares)) return false;
            else sumOfSquaresAlreadySeen.add(currentSumOfSquares);

            number = currentSumOfSquares;
        }
    }

    private static boolean isHappy_solution_2(int number) {
        Set<Integer> sumOfSquaresAlreadySeen = new HashSet<>();

        while (number != 1 && !sumOfSquaresAlreadySeen.contains(number)) {
            sumOfSquaresAlreadySeen.add(number);
            number = getNextNumber(number);
        }

        return number == 1;
    }

    private static boolean isHappy_solution_using_floyd_cycle_finding_algorithm(int number) {
        int slowRunner = number;
        int fastRunner = getNextNumber(number);

        while (fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = getNextNumber(slowRunner);
            fastRunner = getNextNumber(getNextNumber(fastRunner));
        }

        return fastRunner == 1;
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
