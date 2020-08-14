package recusionbacktracking;

import java.util.ArrayList;
import java.util.List;

/*
 *  Best BackTracking question
 *
 *   Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 *   A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 * */
public class PhoneMnemonics {

    public static void main(String[] args) {

        List<String> list = letterCombinations("234");

        for (String s : list)
            System.out.print(s + " ");

    }

    private static List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0 || digits == null)
            return result;

        String[] mapping = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


        solve(digits, mapping, result, 0, "");

        return result;
    }

    private static void solve(String digits, String[] mapping, List<String> result, int currentIndex, String currentResult) {

        if (currentIndex == digits.length()) {
            result.add(currentResult);
            return;
        }

        int number = digits.charAt(currentIndex) - '0';

        for (int i = 0; i < mapping[number].length(); i++) {
            char present = mapping[number].charAt(i);

            solve(digits, mapping, result, currentIndex + 1, currentResult + present);
        }


    }

}
