package Algorithm;

import java.util.Scanner;

public class MatchingA391 {

    public static int matching(String s) {
        int res = 0, count = 0, j = 1;        //GTTAAAG

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(j) && i < s.length() - 1) {
                count++;
            }

            if (count % 2 == 0) {
                res++;
            }
            j++;
        }

        /*while (i < s.length() && j < s.length())
        {
            if(s.charAt(i) == s.charAt(j))
            {
                j++;
            }
            else
            {
                if((j-i) % 2 == 0)
                {
                    res++;
                    i = j;
                    j++;
                }
                else
                {
                    i = j;
                }
            }
        }*/
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.print(matching(s));
    }
}
