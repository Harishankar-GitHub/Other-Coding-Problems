import java.util.HashSet;
import java.util.Set;

public class Solution {

    // Problem statement:
    // https://www.linkedin.com/posts/coding-club_asked-activity-6891652038996975616-Sa98
    // https://www.geeksforgeeks.org/find-common-elements-three-sorted-arrays/

    public static void main(String[] args) {
        Set<Integer> commonElementsInThreeSortedArrays = commonElementsInThreeSortedArrays(
                new int[]{1, 5, 10, 20, 40, 80},
                new int[]{6, 7, 20, 80, 100},
                new int[]{3, 4, 15, 20, 30, 70, 80, 120});

        commonElementsInThreeSortedArrays.forEach(System.out::println);
    }

    static Set<Integer> commonElementsInThreeSortedArrays(int[] array1, int[] array2, int[] array3) {
        Set<Integer> commonElementsSet = new HashSet<>();
        int start1 = 0, start2 = 0, start3 = 0;

        while (start1 < array1.length && start2 < array2.length && start3 < array3.length) {
            int array1_Num = array1[start1];
            int array2_Num = array2[start2];
            int array3_Num = array3[start3];

            if (array1_Num == array2_Num && array2_Num == array3_Num) {
                commonElementsSet.add(array1_Num);
                start1++;
                start2++;
                start3++;
            } else {
                int max = Math.max(array1_Num, array2_Num);
                max = Math.max(max, array3_Num);

                if (array1_Num != max) start1++;
                if (array2_Num != max) start2++;
                if (array3_Num != max) start3++;
            }
        }
        return commonElementsSet;
    }
}
