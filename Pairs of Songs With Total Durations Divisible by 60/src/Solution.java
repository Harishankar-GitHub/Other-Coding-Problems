import java.util.HashMap;
import java.util.Map;

public class Solution {

    // Problem statement: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
    // Solution:
    // https://www.youtube.com/watch?v=gMtxNQHy388
    // https://www.youtube.com/watch?v=5gHnQ4lfDko

    public static void main(String[] args) {
        System.out.println("Method 1");
        System.out.println(numPairsDivisibleBy60_method_1(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60_method_1(new int[]{60, 60, 60}));

        System.out.println("Method 2");
        System.out.println(numPairsDivisibleBy60_method_2(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60_method_2(new int[]{60, 60, 60}));

        System.out.println("Method 3");
        System.out.println(numPairsDivisibleBy60_method_3(new int[]{30, 20, 150, 100, 40}));
        System.out.println(numPairsDivisibleBy60_method_3(new int[]{60, 60, 60}));
    }

    public static int numPairsDivisibleBy60_method_1(int[] time) {
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int currentSongTime : time) {
            int remainder = currentSongTime % 60;

            if (remainder == 0)
                pairs += map.getOrDefault(0, 0);
            else
                pairs += map.getOrDefault(60 - remainder, 0);

            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
        }
        return pairs;
    }

    public static int numPairsDivisibleBy60_method_2(int[] time) {
        int pairs = 0;
        int[] array = new int[60];

        for (int currentSongTime : time) {
            int remainder = currentSongTime % 60;

            if (remainder == 0)
                pairs += array[0];
            else
                pairs += array[60 - remainder];

            array[remainder] += 1;
        }
        return pairs;
    }

    public static int numPairsDivisibleBy60_method_3(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        for (int currentSongTime : time) {
            int reducedTime = currentSongTime % 60;
            int theOther = (reducedTime == 0) ? 0 : 60 - reducedTime;
//             int theOther = (60 - currentSongTime % 60) % 60;
            pairs += map.getOrDefault(theOther, 0); // in current HashMap, get the number of songs that if adding currentSongTime equals to a multiple of 60.
            map.put(currentSongTime % 60,  map.getOrDefault(currentSongTime % 60, 0) + 1); // update the number of currentSongTime % 60.
        }
        return pairs;
    }
}
