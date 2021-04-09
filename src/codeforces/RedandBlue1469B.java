package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class RedandBlue1469B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tt = sc.nextInt();

        while (tt-- > 0) {
            int n = sc.nextInt(), redMax = 0;
            int[] red = new int[n], redPre = new int[n];

            Arrays.fill(redPre, 0);

            for (int i = 0; i < n; i++) {
                red[i] = sc.nextInt();
                if (i != 0) {
                    redPre[i] = redPre[i - 1] + red[i];
                } else if (i == 0)
                    redPre[i] = red[i];

                redMax = Math.max(redMax, redPre[i]);
            }

            int m = sc.nextInt(), blueMax = 0;
            int[] blue = new int[m], preBlue = new int[m];

            for (int i = 0; i < m; i++) {
                blue[i] = sc.nextInt();

                if (i != 0) {
                    preBlue[i] = blue[i] + preBlue[i - 1];
                } else if (i == 0)
                    preBlue[i] = blue[i];

                blueMax = Math.max(blueMax, preBlue[i]);
            }

            System.out.println((redMax + blueMax));
        }
    }
}
