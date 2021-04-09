package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganiseString {
    public static void main(String[] args) {
        System.out.println(new Solution().reorganizeString("aab"));
    }
}

class Solution {
    public String reorganizeString(String S) {

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (a, b) -> b.getValue() - a.getValue()
        );

        StringBuilder sb = new StringBuilder();

        Map<Character, Integer> map = new HashMap();

        for (int i = 0; i < S.length(); i++) {
            map.put(S.charAt(i), map.getOrDefault(S.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        while (maxHeap.size() > 1) {
            Map.Entry<Character, Integer> curr = maxHeap.poll();
            Map.Entry<Character, Integer> next = maxHeap.poll();


            sb.append(curr.getKey());
            sb.append(next.getKey());
            int currFreq = curr.getValue(), nextFreq = next.getValue();

            currFreq--;
            nextFreq--;

            curr.setValue(currFreq);
            next.setValue(nextFreq);

            if (currFreq > 0)
                maxHeap.add(curr);
            if (nextFreq > 0)
                maxHeap.add(next);

        }

        if (maxHeap.isEmpty() == false) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            if (entry.getValue() > 1)
                return "";

            sb.append(entry.getKey());
        }


        return sb.toString();
    }
}