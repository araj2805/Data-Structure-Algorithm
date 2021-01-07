package Template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {

        int[] nums = {1,3,5,7,9};

        System.out.println(countPairs(nums));

    }
    public static int countPairs(int[] nums) {

        long count = 0, mod = (long)1e9+7;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i]; // X + Y = 2^z so here X is element

            // calculating and finding 2^z - X
            for (int j = 0; j < 32; j++) {

                long temp = (long)Math.pow(2,j); // 2^z

                // 2^z - x
                if(map.containsKey(temp - element)) {
                    count += map.get(temp - element);
                }
            }

            map.put(element, map.getOrDefault(element,0) + 1);
        }

        return (int)count;
    }


}