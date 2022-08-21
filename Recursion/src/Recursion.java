public class Recursion {

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("2 power 5: " + twoPower(5));
        System.out.println("Print numbers from 5-1:");
        printFiveToOne(5);
        System.out.println("Print numbers from 1-5:");
        printOneToFive(5);
        System.out.println("Say Digits");
        sayDigits(123);
        System.out.println("Say Digits");
        sayDigits(456);
    }

    private static int factorial(int n) {
        // 5! = 5 * 4 * 3 * 2 * 1
        // 5! = 5 * 4!
        // 4! = 4 * 3!
        // 3! = 3 * 2!
        // 2! = 2 * 1!
        // 1! = 1 * 0!
        // 0! = 0;      // Base case

        // Base case
        if (n == 0) return 1;

        return n * factorial(n-1);
    }

    private static int twoPower(int n) {
        // 2^5 = 2 * 2^4 = 2 * 16
        // 2^4 = 2 * 2^3
        // 2^3 = 2 * 2^2
        // 2^2 = 2 * 2^1
        // 2^1 = 2 * 2^0
        // 2^0 = 1      // Base case

        // Base case
        if (n == 0) return 1;

        return 2 * twoPower(n-1);
    }

    private static void printOneToFive(int n) {
        // Base case
        if (n == 0) return;

        // Head Recursion - Recursive call comes before processing.
        printOneToFive(n-1);

        System.out.println(n);
    }

    private static void printFiveToOne(int n) {
        System.out.println(n);

        // Base case
        if (n == 1) return;

        // Tail Recursion - Recursive call comes after processing.
        printFiveToOne(n-1);
    }

    private static void sayDigits(int n) {
        String[] digitsArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        sayDigits(n, digitsArr);
    }

    private static void sayDigits(int n, String[] digitsArr) {
        if (n == 0) return;

        int lastDigit = n % 10;
        n = n / 10;

        sayDigits(n, digitsArr);

        System.out.println(digitsArr[lastDigit]);
    }
}
