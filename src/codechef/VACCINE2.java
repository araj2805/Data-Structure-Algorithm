package codechef;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VACCINE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt(), d = sc.nextInt();
                int[] arr = new int[n];

                List<Integer> list = new ArrayList<>(n);
                for (int i = 0; i < n; i++)
//                    list.add(sc.nextInt());
                    arr[i] = sc.nextInt();


                int days = 0, count_danger = 0, count_normal = 0;


                for (int i = 0; i < n; i++) {
                    if (arr[i] >= 80 || arr[i] <= 9)
                        count_danger++;
                    else
                        count_normal++;
                }

                days = ((count_danger + d - 1) / d) + ((count_normal + d - 1) / d);

                System.out.println(days);

            }
        }
    }
}
