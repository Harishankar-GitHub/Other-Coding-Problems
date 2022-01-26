public class Solution {

    // Problem statement:
    // https://www.interviewbit.com/blog/subarray-with-given-sum/

    public static void main(String[] args) {
        System.out.println("Method 1");
        System.out.println(subarrayWithGivenSum_method_1(new int[]{1, 4, 20, 3, 10, 5}, 33));
        System.out.println(subarrayWithGivenSum_method_1(new int[]{1, 4, 0, 0, 3, 10, 5}, 7));
        System.out.println(subarrayWithGivenSum_method_1(new int[]{1, 4}, 0));

        System.out.println("Method 2");
        System.out.println(subarrayWithGivenSum_method_2(new int[]{1, 4, 20, 3, 10, 5}, 33));
        System.out.println(subarrayWithGivenSum_method_2(new int[]{1, 4, 0, 0, 3, 10, 5}, 7));
        System.out.println(subarrayWithGivenSum_method_2(new int[]{1, 4}, 0));
    }

    static boolean subarrayWithGivenSum_method_1(int[] arr, int targetSum) {
        int currentSum = arr[0];
        int start = 0;

        for (int i = 1; i < arr.length; i++) {

            while (currentSum > targetSum && start < i - 1) {
                currentSum -= arr[start];
                start += 1;
            }

            if (currentSum == targetSum) return true;

            currentSum += arr[i];
        }
        return false;
    }

    static boolean subarrayWithGivenSum_method_2(int[] arr, int targetSum) {
        int start = 0;
        int next = 1;
        int arrayLength = arr.length;
        int runningSum = arr[start] + arr[next];

        if (arrayLength <= 2 && runningSum != targetSum) {
            return false;
        }

        while (next < arrayLength) {
            if (runningSum == targetSum) {
                return true;
            } else if (runningSum > targetSum) {
                runningSum -= arr[start];
                start += 1;
            } else {
                next += 1;
                if (next < arrayLength) {
                    runningSum += arr[next];
                }
            }
        }
        return false;
    }
}
