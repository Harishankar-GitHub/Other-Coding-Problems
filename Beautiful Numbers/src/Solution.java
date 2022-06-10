import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem:
    // https://www.hackerearth.com/problem/algorithm/beautiful-numbers-05de0f51-101121ca/

    public static void main(String[] args) {
        System.out.println("Sum of Beautiful Numbers between 31, 32:  " + beautifulNumbers(31, 32));
        System.out.println("Sum of Beautiful Numbers between 1, 5:  " + beautifulNumbers(1, 5));
    }

    private static long beautifulNumbers(int l, int r) {
        long sumOfBeautifulNumbers = 0;
        int currentSumOfSquares;
        Set<Integer> sumOfSquares;;

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
}
