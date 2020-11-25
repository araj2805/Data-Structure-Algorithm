package codechef;

import java.util.Scanner;

public class LAPIN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int t = sc.nextInt();

            while (t-- > 0) {
                String s = sc.next();

                int n = s.length();

                System.out.println(lapindrome(s, n) == true ? "YES" : "NO");
            }
        }
    }

    private static boolean lapindrome(String s, int n) {

        int[] map = new int[26];

        if (n % 2 == 0) {
            int i = 0;
            while (i < n / 2) {
                map[s.charAt(i) - 'a']++;
                i++;
            }

            while (i < n) {
                map[s.charAt(i) - 'a']--;
                i++;
            }

            for (i = 0; i < 26; i++) {
                if (map[i] > 0 || map[i] < 0)
                    return false;
            }
        } else {
            int i = 0;
            while (i < n / 2) {
                map[s.charAt(i) - 'a']++;
                i++;
            }
            i++;

            while (i < n) {
                map[s.charAt(i) - 'a']--;
                i++;
            }

            for (i = 0; i < 26; i++) {
                if (map[i] > 0 || map[i] < 0)
                    return false;
            }
        }


        return true;
    }
}
