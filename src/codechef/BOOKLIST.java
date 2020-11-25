package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BOOKLIST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int m = sc.nextInt();
            List<Integer> nums = new ArrayList<>();

            for (int i = 0; i < m; i++)
                nums.add(sc.nextInt());

            int n = sc.nextInt();

            while (n-- > 0) {
                int regIdx = sc.nextInt();
                System.out.println(nums.get(regIdx - 1));
                nums.remove(regIdx);
            }
        }
    }
}
