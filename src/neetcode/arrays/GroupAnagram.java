package neetcode.arrays;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GroupAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {

            int[] freq = new int[26];
            for (char ch : strs[i].toCharArray())
                freq[ch - 'a']++;

            String key = getKey(freq);

//            map.putIfAbsent(key, new ArrayList<>());
//            map.get(key).add(strs[i]);

            if (map.containsKey(key)) {
                map.get(key).add(strs[i]);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(key, list);
            }
        }



        return new ArrayList<>(map.values());

    }

    private String getKey(int[] freq) {
        String key = "";
        for (int i = 0; i < 26; i++)
            if(freq[i] > 0)
                key += String.valueOf((char)(i + 'a'))+freq[i];

        return key;
    }

    public List<List<String>> groupAnagramsStream(String[] strs) {

        List<List<String>> list = Arrays.stream(strs).collect(Collectors.groupingBy(word -> getFrequencyKey(word))).values().stream().toList();


        return list;
    }

    // Generate a unique frequency-based key for each word
    private String getFrequencyKey(String word) {
        int[] frequency = new int[26];  // Array for counting frequency of each letter (a-z)

        // Count frequencies of each character
        word.chars().mapToObj(ch -> (char)ch).forEach(ch -> frequency[ch - 'a']++);

        // Convert the frequency array into a string key (or use a tuple-like structure)
        StringBuilder key = new StringBuilder();
        IntStream.range(0,25).forEach(i -> {
            if (frequency[i] > 0)
                key.append((char)(i+'a')).append(frequency[i]);
        });

        return key.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GroupAnagram().groupAnagrams(new String[]{"act","pots","tops","cat","stop","hat"}));
        System.out.println(new GroupAnagram().groupAnagramsStream(new String[]{"act","pots","tops","cat","stop","hat"}));
    }
}


