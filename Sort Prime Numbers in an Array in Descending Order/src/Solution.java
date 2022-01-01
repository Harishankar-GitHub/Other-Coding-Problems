import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6882904779249594368-yAKa
    // https://www.geeksforgeeks.org/sort-prime-numbers-of-an-array-in-descending-order/

    // Reference Links:
    // https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
    // https://www.geeksforgeeks.org/sieve-of-eratosthenes/

    static boolean[] PRIME = new boolean[100005];

    public static void main(String[] args) {
        System.out.println("Method 1: " + Arrays.toString(sortPrimeNumbersInDescendingOrder_method_1(new int[]{2, 5, 8, 4, 3})));
        System.out.println("Method 1: " + Arrays.toString(sortPrimeNumbersInDescendingOrder_method_1(new int[]{10, 12, 2, 6, 5})));

        System.out.println("Method 2: " + Arrays.toString(sortPrimeNumbersInDescendingOrder_method_2(new int[]{2, 5, 8, 4, 3})));
        System.out.println("Method 2: " + Arrays.toString(sortPrimeNumbersInDescendingOrder_method_2(new int[]{10, 12, 2, 6, 5})));

        // Method 2 is better.
    }

    public static int[] sortPrimeNumbersInDescendingOrder_method_1(int[] array) {
        List<Integer> primeNumbers = new ArrayList<>();

        for (int num : array) {
            if (isPrime(num)) {
                primeNumbers.add(num);
            }
        }

        primeNumbers.sort(Collections.reverseOrder());

        int primeNumbersIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (primeNumbers.contains(array[i])) {
                array[i] = primeNumbers.get(primeNumbersIndex);
                primeNumbersIndex += 1;
            }
        }

        return array;
    }

    public static int[] sortPrimeNumbersInDescendingOrder_method_2(int[] array) {

        SieveOfEratosthenes(100000);
        List<Integer> primeNumbers = new ArrayList<>();

        for (int num : array) {
            if (PRIME[num]) {
                primeNumbers.add(num);
            }
        }

        primeNumbers.sort(Collections.reverseOrder());

        int j = 0;

        // update the array elements
        for (int i = 0; i < array.length; i++) {
            if (PRIME[array[i]]) {
                array[i] = primeNumbers.get(j++);
            }
        }

        return array;
    }

    private static boolean isPrime(int num) {
        if (num == 2) return true;
        if (num < 2 || num % 2 == 0) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void SieveOfEratosthenes(int n) {
        Arrays.fill(PRIME, true);

        // false here indicates that it is not prime
        PRIME[1] = false;

        for (int i = 2; i * i <= n; i++) {
            // If prime[p] is not changed, then it is a prime
            if (PRIME[i]) {
                // Update all multiples of p, set them to non-prime
                for (int j = i * 2; j < n; j += i) {
                    PRIME[j] = false;
                }
            }
        }
    }
}
