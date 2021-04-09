package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BovineDilemma1466A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];

            Set<Double> set = new HashSet<>();

            for (int i = 0; i < n; i++)
                nums[i] = sc.nextInt();

            double areaM = (0.5) * (nums[0]);


            for (int i = 0; i < n; i++) {
                double areaMaster = (0.5) * (nums[i]);

                for (int j = i + 1; j < n; j++) {
                    double area = (0.5) * nums[j];
                    double areaFinal = area - areaMaster;
                    if (areaFinal > 0)
                        set.add(areaFinal);
                }

            }

            /*for(int i = 1; i < n; i++) {
                double area = (0.5) * nums[i];
                double finalArea = area - areaM;
                set.add(finalArea);
            }*/

            System.out.println(set.size());

        }
    }
}
