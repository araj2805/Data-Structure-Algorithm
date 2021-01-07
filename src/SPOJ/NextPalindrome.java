package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NextPalindrome {

    /*
     *  Main Method : public static void main
     * */

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {

            String num = br.readLine();
            String ans = nextPalindrome(num.trim());
            System.out.println(ans);
        }
    }

    private static String nextPalindrome(String num) {

        int n = num.length();
        char[] arr = num.toCharArray();


        for (int i = 0; i < n / 2; i++) {
            arr[n - i - 1] = arr[i];
        }

        String tmp = new String(arr);

//        Arr string is grater than k
        if (tmp.compareTo(num) > 0)
            return tmp;
        else {
            for (int i = (n - 1) / 2; i >= 0; i--) {
                if (arr[i] != '9') {
                    arr[i] += 1;
                    break;
                } else {
                    arr[i] = '0';
                }
            }

            for (int i = 0; i < n / 2; i++) {
                arr[n - i - 1] = arr[i];
            }

            if (arr[0] == '0') {
                arr[0] = '1';
                return new String(arr) + "1";
            }

            return String.valueOf(arr);
        }

    }

}