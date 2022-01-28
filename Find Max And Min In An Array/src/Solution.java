public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6890575002962644993-UM7e
    // https://www.geeksforgeeks.org/maximum-and-minimum-in-an-array/

    public static void main(String[] args) {
        minAndMax(new int[]{1000, 11, 445, 1, 330, 3000});
    }

    static void minAndMax(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int num : array) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println("Minimum: " + min + " Maximum: " + max);
    }
}
