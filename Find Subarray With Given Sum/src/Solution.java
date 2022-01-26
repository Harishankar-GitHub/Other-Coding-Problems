public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6891672432978075649-PqoL
    // https://www.geeksforgeeks.org/find-subarray-with-given-sum/
    // https://leetcode.com/discuss/interview-question/algorithms/124938/google-subarray-sum-equals-target

    public static void main(String[] args) {
        System.out.println("Method 1");
        findSubarrayWithGivenSum_method_1(new int[]{1, 4, 20, 3, 10, 5}, 33);
        findSubarrayWithGivenSum_method_1(new int[]{1, 4, 0, 0, 3, 10, 5}, 7);
        findSubarrayWithGivenSum_method_1(new int[]{1, 4}, 0);

        System.out.println("Method 2");
        findSubarrayWithGivenSum_method_2(new int[]{1, 4, 20, 3, 10, 5}, 33);
        findSubarrayWithGivenSum_method_2(new int[]{1, 4, 0, 0, 3, 10, 5}, 7);
        findSubarrayWithGivenSum_method_2(new int[]{1, 4}, 0);
    }

    static void findSubarrayWithGivenSum_method_1(int[] arr, int targetSum) {
        int currentSum = arr[0];
        int start = 0;
        int arrayLength = arr.length;

        for (int i = 1; i <= arrayLength - 1; i++) {

            while (currentSum > targetSum && start < i - 1) {
                currentSum -= arr[start];
                start += 1;
            }

            if (currentSum == targetSum) {
                System.out.println("Sum found between indexes " + start + " and " + (i - 1));
                return;
            }

            currentSum += arr[i];
        }
        System.out.println("No subarray found");
    }

    static void findSubarrayWithGivenSum_method_2(int[] arr, int targetSum) {
        int start = 0;
        int next = 1;
        int arrayLength = arr.length;
        int runningSum = arr[start] + arr[next];

        if (arrayLength <= 2 && runningSum != targetSum) {
            System.out.println("No subarray found");
            return;
        }

        while (next < arrayLength) {
            if (runningSum == targetSum) {
                System.out.println("Sum found between indexes " + start + " and " + next);
                return;
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
        System.out.println("No subarray found");
    }
}
