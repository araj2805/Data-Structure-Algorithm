package codeforces;

import java.util.Scanner;

public class JzzhuChildren450A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        int [] nums = new int[n];

        for(int i = 0; i < n ; i++)
            nums[i] = sc.nextInt();

        int last = -1;


        for(int i = 0; i < n; i++)
        {
            int temp = nums[i] % m;

//            if(last  < i + 1)

        }

        System.out.println(last);
    }
}
