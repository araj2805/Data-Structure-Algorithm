package Revision;

public class LongestPlandromicSubstring {


    public static void main(String[] args) {
//        System.out.println(longestPalindrome("abaxyzzyxf"));
        System.out.println(longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {

        int start = 0, end = 0;

        if (s == null || s.length() == 0)
            return "";

        for (int i = 0; i < s.length(); i++) {
            int oddLen = getPalindromeLength(s, i, i);
            int evenLen = getPalindromeLength(s, i - 1, i);

            int longestLen = Math.max(oddLen, evenLen);

            if (end - start + 1 < longestLen) {
                start = i - ((longestLen) / 2);
                end = i + ((longestLen - 1) / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    private static int getPalindromeLength(String s, int leftIndex, int rightIndex) {

        while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
            leftIndex--;
            rightIndex++;
        }

        return rightIndex - leftIndex - 1;
    }


}
