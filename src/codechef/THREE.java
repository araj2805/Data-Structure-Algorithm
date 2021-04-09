package codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class THREE {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        if (sc.hasNextInt()) {
            int tt = sc.nextInt();

            while (tt-- > 0) {
                String str = sc.next();

                System.out.println(solve(str));
            }
        }
    }

    private static int solve(String str) {

        Map<Character, Integer> map = new HashMap<>();

//        Making frequency of each character
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int ans = 0;
        for (Character ch : map.keySet()) {
            ans += map.get(ch) / 2; // getting all the pair that is eligible for making palindrome
        }

        return Math.min(ans, str.length() / 3); // Comparing with len / 3 because maximum len / 3 palindrome can be present in string of length len
    }
}
