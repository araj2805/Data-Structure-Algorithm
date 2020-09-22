package codeforces;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrogJumps {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        while (t-- > 0) {
            String str = scan.next();

            List<Integer> indices = new ArrayList<>();
            indices.add(0);

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'R')
                    indices.add(i + 1);
            }

            indices.add(str.length() + 1);

            int res = 0;

            for (int i = 0; i < indices.size() - 1; ++i) {
                res = Math.max(res, indices.get(i + 1) - indices.get(i));
            }

            System.out.println(res);
        }


    }
}
