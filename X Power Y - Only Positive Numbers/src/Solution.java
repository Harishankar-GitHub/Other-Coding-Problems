public class Solution {

    public static void main(String[] args) {
        System.out.println("2 power 5: " + power(2, 5));
        System.out.println("2 power 10: " + power(2, 10));
        System.out.println("2 power 9: " + power(2, 9));
        System.out.println("5 power 3: " + power(5, 3));
        System.out.println("3 power 6: " + power(3, 6));
        System.out.println("9 power 3: " + power(9, 3));
    }

    // Note:
    // 2^10 = 2^5 * 2^5
    // 2^5 = 2 * 2^4 * 2^4
    // 2^4 = 2^2 * 2^2
    // 2^2 = 2^1 * 2^1
    // 2^1 = 2 * 2^0 * 2^0
    // 2^0 = 1

    private static int power(int a, int b) {
        if (b == 0) return 1;
        if (b == 1) return a;

        int ans = power(a, b/2);

        if (b%2 == 0) return ans * ans;
        else return a * ans * ans;
    }
}
