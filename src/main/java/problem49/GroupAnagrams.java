package problem49;

import java.util.*;

public final class GroupAnagrams {

    public List<List<String>> groupAnagrams(final String[] strs) {
        final List<List<String>> result = new LinkedList<>();
        final Map<String, List<String>> anagramsMap = new HashMap<>();

        for (var str : strs) {
            var strArr = str.toCharArray();
            Arrays.sort(strArr);
            var sortedStr = new String(strArr);

            anagramsMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }

        for (var en : anagramsMap.entrySet()) {
            result.add(en.getValue());
        }

        return result;
    }

}
