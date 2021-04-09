package codechef;

import java.util.Arrays;
import java.util.Scanner;

public class FAIRELCT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            outer:
            while (tt-- > 0) {
                int n = sc.nextInt(), m = sc.nextInt();

                long[] a = new long[n], b = new long[m];
                long john = 0, jack = 0;

                for (int i = 0; i < n; i++) {
                    a[i] = sc.nextLong();
                    john += a[i];
                }

                for (int i = 0; i < m; i++) {
                    b[i] = sc.nextLong();
                    jack += b[i];
                }

                if (john > jack) {
                    System.out.println(0);
                    continue outer;
                }

                Arrays.sort(a);
                Arrays.sort(b);

                int i = 0, j = m - 1;
                long count = 0;


                while (i < n && j >= 0 && john <= jack) {
                    long johnEle = a[i], jackEle = b[j];

                    if (johnEle >= jackEle) {
                        System.out.println(-1);
                        continue outer;
                    }

                    if (johnEle < jackEle) {

                        count++;

                        long temp = a[i];
                        a[i] = b[j];
                        b[j] = temp;

                        john = (john + jackEle - johnEle);
                        jack = (jack + johnEle - jackEle);

                        i++;
                        j--;
                    } else {
                        System.out.println(-1);
                        continue outer;
                    }

                }

                if (john > jack)
                    System.out.println(count);
                else
                    System.out.println(-1);


//                System.out.println(count == 0 || jack >= john? -1 : count);
            }
        }
    }
}
/*
* 1
10 7
1 1 1 1 1 1 1 1 1 1
2 2 2 2 2 2 2
* */