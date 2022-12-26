class Solution {

    // Problem statement: https://leetcode.com/problems/powx-n/description/

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, 10));
        System.out.println(myPow(2.10000, 3));
        System.out.println(myPow(2.00000, -2));
        // Note:
        // 2^10 = 2^5 * 2^5
        // 2^5 = 2 * 2^4 * 2^4
        // 2^4 = 2^2 * 2^2
        // 2^2 = 2^1 * 2^1
        // 2^1 = 2 * 2^0 * 2^0
        // 2^0 = 1

        // Negative number
        // 2^-2 = 1/2^2 = 1/4 = 0.25
    }

    public static double myPow(double x, int n) {
        if (n==0) return 1;
        if (n > 0) return myCustomPow(x,n);
        else return 1/myCustomPow(x, -n);
    }

    private static double myCustomPow(double x, long n) {
        if (n == 0) return 1;
        if (n == 1) return x;

        double ans = myCustomPow(x,n/2);

        if (n % 2 ==0) return ans * ans;
        else return x * ans * ans;
    }
}
