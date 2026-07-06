import java.util.*;

public class GroupAnagrams2 {

    public static List<List<String>> groupAnagramsCategorizeByFrequency(String[] strs) {

        // Check for empty input
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> frequencyStringsMap = new HashMap<>();

        for (String str : strs) {

            String frequencyString = getFrequencyString(str);

            if (frequencyStringsMap.containsKey(frequencyString)) {
                frequencyStringsMap.get(frequencyString).add(str);
            } else {
                List<String> strList = new ArrayList<>();
                strList.add(str);
                frequencyStringsMap.put(frequencyString, strList);
            }
        }

        return new ArrayList<>(frequencyStringsMap.values());
    }

    private static String getFrequencyString(String str) {

        // Frequency array
        int[] freq = new int[26];

        // Count frequency of each character
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        // Build frequency string
        StringBuilder frequencyString = new StringBuilder();

        char c = 'a';

        for (int count : freq) {
            frequencyString.append(c);
            frequencyString.append(count);
            c++;
        }

        return frequencyString.toString();
    }

    public static void main(String[] args) {

        String[] arr = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };

        List<List<String>> result = groupAnagramsCategorizeByFrequency(arr);

        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}