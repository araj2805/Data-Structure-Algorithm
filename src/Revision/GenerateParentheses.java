package Revision;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();

        if (n == 0)
            return res;


        generate(n, 0, 0, res, "");

        return res;
    }

    private static void generate(int n, int openingBracket, int closingBracket, List<String> res, String output) {

        if (output.length() == 2 * n) {
            res.add(output);
            return;
        }
        if (openingBracket < n)
            generate(n, openingBracket + 1, closingBracket, res, output + "(");
        if (closingBracket < n && openingBracket > closingBracket)
            generate(n, openingBracket, closingBracket + 1, res, output + ")");


    }
}
