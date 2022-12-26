import java.util.Arrays;

public class Solution {

    // Problem statement: https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17,18,5,4,6,1})));
        System.out.println(Arrays.toString(replaceElements(new int[]{400})));
    }

    public static int[] replaceElements(int[] arr) {

        // O(n) time | O(1) space

        int length = arr.length;
        int greatestSoFar = arr[length - 1];

        for (int i = length - 2; i >= 0; i--) {
            int currentNum = arr[i];

            arr[i] = greatestSoFar;

            if (currentNum > greatestSoFar) greatestSoFar = currentNum;
        }

        arr[length - 1] = -1;
        return arr;
    }
}
