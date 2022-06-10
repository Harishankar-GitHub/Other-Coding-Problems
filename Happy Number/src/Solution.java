import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem:
    // https://leetcode.com/problems/happy-number/

    public static void main(String[] args) {
        System.out.println("Is 32 a Happy Number? " + isHappy(32));
        System.out.println("Is 31 a Happy Number? " + isHappy(31));
        System.out.println("Is 7 a Happy Number? " + isHappy(7));
        System.out.println("Is 2 a Happy Number? " + isHappy(2));
        System.out.println("Is 1 a Happy Number? " + isHappy(1));
        System.out.println("Is 63 a Happy Number? " + isHappy(63));
        System.out.println("Is 19 a Happy Number? " + isHappy(19));
    }

    private static boolean isHappy(int number) {
        int currentSumOfSquares;
        Set<Integer> sumOfSquaresAlreadySeen = new HashSet<>();

        while (true) {
            currentSumOfSquares = 0;
            while (number > 0) {
                int lastDigit = number % 10;
                currentSumOfSquares += lastDigit * lastDigit;
                number = number / 10;
            }

            if (currentSumOfSquares == 1) return true;
            if (sumOfSquaresAlreadySeen.contains(currentSumOfSquares)) return false;
            else sumOfSquaresAlreadySeen.add(currentSumOfSquares);

            number = currentSumOfSquares;
        }
    }
}
