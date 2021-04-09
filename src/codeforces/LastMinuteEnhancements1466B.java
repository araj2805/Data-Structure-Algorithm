package codeforces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LastMinuteEnhancements1466B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }

            for (int i : nums) {
                int freq = map.get(i);

                if (freq > 1 && map.getOrDefault(i + 1, 0) >= 0) {
                    map.put(i, freq - 1);
                    map.put(i + 1, map.getOrDefault(i + 1, 0) + 1);
                }
            }

            /*for (Integer i : map.keySet()) {
                System.out.print(i+" "+map.get(i)+" ");
                System.out.println();
            }
            System.out.println();*/

            System.out.println(map.size());
        }
    }
}
