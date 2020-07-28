package recusionbacktracking;

public class WordBreakProblem {

    /*public static String dictionary[] = {"mobile", "samsung", "sam", "sung",
            "man", "mango", "icecream", "and",
            "go", "i", "love", "ice", "cream"};*/

    public static String dictionary[] = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};

    public static void main(String[] args) {
//        String str = "ilovesamsungmobile";

        String str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        wordBreak(str);
    }

    static void wordBreak(String str) {

        int n = str.length();

        /*
         * str : input string
         * n : length of string
         * "" : result string
         * */
        solveWordBreak(str, n, "");
    }

    static void solveWordBreak(String str, int n, String result) {

        for (int i = 1; i <= n; i++) {
            String prefix = str.substring(0, i);

            if (isPresent(prefix) == true) {
                // No more element are there i.e all sentence is consumed : BASE CASE
                if (i == n) {
                    // add result to previous prefix
                    result += prefix;
                    System.out.println(result);
                    return;

                }
                System.out.println(str.substring(i));

                solveWordBreak(str.substring(i), n - i, result + prefix + " ");
            }
        }

    }

    static boolean isPresent(String prefix) {

        for (String s : dictionary) {
            if (s.equals(prefix))
                return true;
        }
        return false;
    }
}
