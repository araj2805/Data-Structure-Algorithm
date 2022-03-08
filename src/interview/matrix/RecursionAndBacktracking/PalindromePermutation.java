package interview.matrix.RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePermutation {

    public static void main(String[] args) {

        System.out.println(palindromePermutation("aaaabbbbccc"));

    }

    public static List<String> palindromePermutation(String str) {

        List<String> res = new ArrayList<>();

        if (str == null || str.length() == 0)
            return res;

        Map<Character, Integer> freqMap = new HashMap<>();

        for (Character c : str.toCharArray())
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);

        int oddCount = 0, length = 0;
        Character oddCharacter = null;

//        This is to make track of odd character, and making frequency half
        for (Character key : freqMap.keySet()) {
            int freqCount = freqMap.get(key);

            if (freqCount % 2 != 0) {
                oddCharacter = key;
                oddCount++;
            }
            freqMap.put(key, freqCount / 2);
            length += freqCount / 2;
        }

//        This ensure that in Plaindrome have only 1 character whose freq is odd
        if (oddCount > 1)
            return res;

        genratePalindromePermutation(0, length, freqMap, oddCharacter, "", res);

        return res;
    }

    private static void genratePalindromePermutation(int currentIndex, int length, Map<Character, Integer> freqMap, Character oddCharacter, String ansSoFar, List<String> res) {

        if (currentIndex == length) {

            String rev = new StringBuilder(ansSoFar).reverse().toString();

            if (oddCharacter != null)
                ansSoFar += oddCharacter;


            res.add(ansSoFar + rev);

            return;
        }

        for (Character c : freqMap.keySet()) {
            if (freqMap.get(c) > 0) {

                int freqCount = freqMap.get(c);

                freqMap.put(c, freqCount - 1);

                genratePalindromePermutation(currentIndex + 1, length, freqMap, oddCharacter, ansSoFar + c, res);

                freqMap.put(c, freqCount);
            }
        }

    }
}
