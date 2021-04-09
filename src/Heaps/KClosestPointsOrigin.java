/*
package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPointsOrigin {
    public static void main(String[] args) {

        int[][] points = {{3,3},{5,-1},{-2,4}};
        int k = 2;

//        System.out.println(new Solution().kClosest(points,k));

        System.out.println(nthUglyNumber(11));

    }

    public static int nthUglyNumber(int n) {
        int count = 1;
        for(int i = 2; i <= 1690; i++) {

            if(i % 2 == 0 || i % 3 == 0 || i % 5 == 0) {

                count++;
                if(count == n)
                    return i;


            }
        }

        return 1;

    }
}


class Solution {
    public int[][] kClosest(int[][] points, int k) {



        PriorityQueue<pair> maxHeap = new PriorityQueue<>((p1,p2) -> p2.dist - p1.dist);

        // List<Integer> dist = new ArrayList<>();

        for(int[] cord : points) {
            int ecuid = cord[0] * cord[0] + cord[1] * cord[1];

            // dist.add(ecuid);

            maxHeap.add(new pair(ecuid, cord));

            if(maxHeap.size() > k)
                maxHeap.poll();
        }

        int[][] res = new int[maxHeap.size()][];

        int i = 0;
        while(maxHeap.isEmpty() == false) {
            res[i++] = maxHeap.poll().cord;
        }


        return res;


    }
}

class pair {
    int dist;
    int[] cord;

    public pair (int dist, int[] cord) {
        this.dist = dist;
        this.cord = cord;
    }
}*/
