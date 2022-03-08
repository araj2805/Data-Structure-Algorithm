package Revision;

import java.util.ArrayList;
import java.util.List;

public class PhoneLetterCOmbination {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }

    public static List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0)
            return res;


        String[] keyPad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        letterFormation(digits, keyPad, res, 0, "");

        return res;
    }

    private static void letterFormation(String digits, String[] keyPad, List<String> res, int currentIndex, String output) {

        if (output.length() == digits.length()) {
            res.add(output);
            return;
        }


        String letters = keyPad[digits.charAt(currentIndex) - '0'];

        for (int i = 0; i < letters.length(); i++) {

            letterFormation(digits, keyPad, res, currentIndex + 1, output + letters.charAt(i));
        }


    }
}
