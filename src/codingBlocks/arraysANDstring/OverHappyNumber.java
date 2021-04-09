package codingBlocks.arraysANDstring;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
*

A 'overhappy' number follows the following criteria:

It is always a positive integer. The integer number is replaced by the sum of the squares of its digits and this process is repeated until the sum equals 1.
The numbers which loop endlessly and never reach to the sum of 1 are not overhappy numbers.
Input Format

First line contains an positive integer n.
Constraints

None
Output Format

Print true if n is overhappy number else print false.
Sample Input

19

Sample Output

true
* */
public class OverHappyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(isHappy(n));
    }

    private static boolean isHappy(int n) {

        Set<Integer> set = new HashSet<>();

        return checkNumber(set, n);
    }

    private static boolean checkNumber(Set<Integer> set, int n) {

        if (n == 1)
            return true;

        if (set.contains(n))
            return false;

        set.add(n);
        n = updatedNumber(n);
        return checkNumber(set, n);
    }

    private static int updatedNumber(int n) {
        int newNumber = 0;

        while (n > 0) {
            int digit = n % 10;
            newNumber += digit * digit;
            n = n / 10;
        }

        return newNumber;
    }
}
