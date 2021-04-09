package codechef;

import java.util.Scanner;

public class DECODEIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                int n = sc.nextInt();

                int ele = n / 4;

                String str = sc.next();

                StringBuilder sb = new StringBuilder("");

                char[] arr = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'};
                int low = 0, high = 15;

                for (int i = 0; i < str.length(); i++) {
                    char ch = str.charAt(i);
                    int mid = low + (high - low) / 2;
                    if (ch == '0') {
                        high = mid;
                    } else if (ch == '1') {
                        low = mid + 1;
                    }

                    if (i > 0 && i % 3 == 0) {
                        sb.append(arr[high]);
                        low = 0;
                        high = 15;
                    }
                }

                System.out.println(sb);
            }
        }
    }


}
