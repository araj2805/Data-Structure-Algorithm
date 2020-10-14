package codeforces;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoyOrGirl236A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray())
            set.add(c);

        System.out.println(set.size() % 2 == 0 ? "CHAT WITH HER!" : "IGNORE HIM!");

    }
}
