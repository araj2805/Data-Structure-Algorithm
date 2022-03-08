package BasicDataStructure;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumDivisibleBySumK974 {

    public static void main(String[] args) {

    }

    public int subarraysDivByK(int[] A, int K) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;

        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int rem = sum % K;
            if (rem < 0)
                rem += K;
            if (map.containsKey(rem) == true) {
                count += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        return count;
    }
}
