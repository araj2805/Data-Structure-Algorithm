package codingBlocks.arraysANDstring;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


/*
*

Given an array of meeting time intervals consisting of start and end times [[S1,E1],[S2,E2],…] (SI < EI), find the minimum number of party halls required.
Input Format

Take input N
Next N line consists of two space-separated integers SI and EI
Constraints

None
Output Format

print minimum required room
Sample Input

5
1 4
2 5
3 6
10 11
11 12

Sample Output

3

* */
public class PartyHallsPriorityQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> intervals = new ArrayList<>();


        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                temp.add(sc.nextInt());
            }
            intervals.add(temp);
        }

//        Ascending order
        intervals.sort((i1, i2) -> i1.get(0) - i2.get(0));

        // Descending order
        //        intervals.sort((i1, i2) -> i2.get(0) - i1.get(0));


        int partyHalls = 0;

        PriorityQueue<Integer> pq = new PriorityQueue();

        for (List<Integer> list : intervals) {
            if (pq.isEmpty()) {
                partyHalls++;
                pq.add(list.get(1));
            } else {
                if (pq.peek() <= list.get(0)) {
                    pq.poll();
                    pq.add(list.get(1));
                } else {
                    partyHalls++;
                    pq.add(list.get(1));
                }
            }
        }
        System.out.println(partyHalls);


    }
}
