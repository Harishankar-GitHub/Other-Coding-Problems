import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem {

    // Problem statement: https://leetcode.com/problems/3sum/

    public static void main(String[] args) {
        printLists(threeSum(new int[]{-1,0,1,2,-1,-4}));
        printLists(threeSum(new int[]{0,1,1}));
        printLists(threeSum(new int[]{0,0,0}));
        printLists(threeSum(new int[]{1,-1,-1,0}));
        printLists(threeSum(new int[]{0,0,0,0}));
        printLists(threeSum(new int[]{-2,0,1,1,2}));
        printLists(threeSum(new int[]{3,0,-2,-1,1,2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        // O(n^2) time | O(n) space

        Set<List<Integer>> resultList = new HashSet<>();

        if (nums.length < 3) {
            return new ArrayList<>(resultList);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int currentNum = nums[i];
                int leftNum = nums[left];
                int rightNum = nums[right];

                int sum = currentNum + leftNum + rightNum;

                if (sum == 0) {
                        resultList.add(Arrays.asList(currentNum, leftNum, rightNum));
                        left++;
                        right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(resultList);
    }

    private static void printLists(List<List<Integer>> lists) {
        System.out.println("-----------------------------------------------");
        for (List<Integer> list : lists) {
            list.forEach(System.out::print);
            System.out.println();
        }
    }
}
