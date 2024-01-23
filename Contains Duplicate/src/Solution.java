import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem statement: https://leetcode.com/problems/contains-duplicate/description/

    public static void main(String[] args) {
        System.out.println(containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }

    public static boolean containsDuplicate(int[] nums) {

        // O(n) time | O(n) space

        Set<Integer> numberSet = new HashSet<>();

        for (int num : nums) {
            if (numberSet.contains(num)) {
                return true;
            } else {
                numberSet.add(num);
            }
        }

        return false;
    }
}
