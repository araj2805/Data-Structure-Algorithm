/*
package Heaps;

import java.util.PriorityQueue;

public class KLargestElement {
    public static void main(String[] args) {

        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        System.out.println(new Solution().findKthLargest(nums,k));
    }
}

class Solution {
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();


        for(int i : nums) {


                minHeap.add(i);


            if(minHeap.size() > k)
                minHeap.poll();

        }

        return minHeap.peek();

    }
}
*/
