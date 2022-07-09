public class Solution {

    // Problem statement: https://leetcode.com/problems/power-of-two/
    // Refer explanation doc in root folder.

    public static void main(String[] args) {
        System.out.println("Is 1 Power of Two? " + isPowerOfTwo(1));
        System.out.println("Is 16 Power of Two? " + isPowerOfTwo(16));
        System.out.println("Is 3 Power of Two? " + isPowerOfTwo(3));
    }

    public static boolean isPowerOfTwo(int n) {

        // O(1) time | O(1) space
        // Using Bit Manipulation

        if (n <= 0) return false;

        int m = n - 1;

        return (m & n) == 0;
    }
}
