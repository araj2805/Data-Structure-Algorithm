package codingBlocks.arraysANDstring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PartyHallsOptmized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> startTime = new ArrayList<>();
        List<Integer> endTime = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            startTime.add(sc.nextInt());
            endTime.add(sc.nextInt());
        }

        System.out.println(helper(startTime, endTime));
    }

    public static int helper(List<Integer> startTime, List<Integer> endTime) {

        startTime.sort((o1, o2) -> o1 - o2);
        endTime.sort((i1, i2) -> i1 - i2);

        int i = 0, j = 0, count = 0, max = 0, n = startTime.size();

        while (i < n && j < n) {
            if (startTime.get(i) < endTime.get(j)) {
                i++;
                count++;
            } else {
                j++;
                count--;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
