public class Solution {

    // Problem statement: https://leetcode.com/problems/container-with-most-water/description/

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(maxArea(new int[]{1,1}));
    }

    public static int maxArea(int[] height) {
        // O(n) time | O(1) space

        int currentArea = 0;
        int maxAreaSoFar = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int leftHeight = height[left];
            int rightHeight = height[right];

            int len = right - left;
            int breadth = Math.min(leftHeight, rightHeight);

            currentArea = len * breadth;
            maxAreaSoFar = Math.max(maxAreaSoFar, currentArea);

            if (leftHeight == rightHeight) {
                left++;
                right--;
            } else if (leftHeight < rightHeight){
                left++;
            } else {
                right--;
            }
        }

        return maxAreaSoFar;
    }
}
