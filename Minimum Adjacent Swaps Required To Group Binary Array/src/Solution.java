public class Solution {

    // Problem statement:
    // https://medium.com/problem-solving-coding/grouping-digits-152457e961f8
    // https://stackoverflow.com/questions/56878798/minimum-number-of-adjacent-swaps-of-binary-array
    // 19/01/2022 - Amazon Coding Interview Question

    public static void main(String[] args) {
        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 1 - {0, 1, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method1(new int[]{0, 1, 0, 1}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 1 - {1, 1, 1, 1, 0, 1, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method1(new int[]{1, 1, 1, 1, 0, 1, 0, 1}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 1 - {1, 1, 1, 1, 0, 0, 0, 0}: " +
                minimumSwapsRequiredToGroupBinaryArray_method1(new int[]{1, 1, 1, 1, 0, 0, 0, 0}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 1 - {1, 0, 1, 0, 0, 0, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method1(new int[]{1, 0, 1, 0, 0, 0, 0, 1}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 2 - {0, 1, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method_2(new int[]{0, 1, 0, 1}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 2 - {1, 1, 1, 1, 0, 1, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method_2(new int[]{1, 1, 1, 1, 0, 1, 0, 1}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 2 - {1, 1, 1, 1, 0, 0, 0, 0}: " +
                minimumSwapsRequiredToGroupBinaryArray_method_2(new int[]{1, 1, 1, 1, 0, 0, 0, 0}));

        System.out.println("Minimum Adjacent Swaps Required To Group Binary Array - Method 2 - {1, 0, 1, 0, 0, 0, 0, 1}: " +
                minimumSwapsRequiredToGroupBinaryArray_method_2(new int[]{1, 0, 1, 0, 0, 0, 0, 1}));
    }

    static int minimumSwapsRequiredToGroupBinaryArray_method1(int[] arr) {
        int index_pointer_0 = 0;
        int swapCount_0 = 0;

        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            if (arr[currentIndex] == 0) {
                swapCount_0 += Math.abs(currentIndex - index_pointer_0);
                index_pointer_0 += 1;
            }
        }

        int index_pointer_1 = 0;
        int swapCount_1 = 0;

        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            if (arr[currentIndex] == 1) {
                swapCount_1 += Math.abs(currentIndex - index_pointer_1);
                index_pointer_1 += 1;
            }
        }
        return Math.min(swapCount_0, swapCount_1);
    }

    static int minimumSwapsRequiredToGroupBinaryArray_method_2(int[] arr) {
        int index_pointer_0 = 0;
        int swapCount_0 = 0;
        int index_pointer_1 = 0;
        int swapCount_1 = 0;

        for (int currentIndex = 0; currentIndex < arr.length; currentIndex++) {
            if (arr[currentIndex] == 0) {
                swapCount_0 += Math.abs(currentIndex - index_pointer_0);
                index_pointer_0 += 1;
            }

            if (arr[currentIndex] == 1) {
                swapCount_1 += Math.abs(currentIndex - index_pointer_1);
                index_pointer_1 += 1;
            }
        }
        return Math.min(swapCount_0, swapCount_1);
    }
}
