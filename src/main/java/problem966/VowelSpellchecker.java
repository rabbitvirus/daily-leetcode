package problem966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class VowelSpellchecker {

    private static final Set<Character> VOVELS = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
    private static final Character PATTERN_REPLACEMENT = '.';

    private final char[] strBuffer = new char[7];

    public String[] spellchecker(final String[] wordlist, final String[] queries) {
        final Set<String> directMatchSet = new HashSet<>();
        final Map<String, String> caseMatchLookup = new HashMap<>();
        final Map<String, String> vowelPatternLookup = new HashMap<>();

        for (int i = wordlist.length - 1; i >= 0; i--) {
            var w = wordlist[i];
            directMatchSet.add(w);
            caseMatchLookup.put(w.toLowerCase(), w);
            vowelPatternLookup.put(toVowelPattern(w), w);
        }

        final String[] result = new String[queries.length];

        for (int i = 0; i < queries.length; i++) {
            var q = queries[i];
            result[i] = "";
            if (directMatchSet.contains(q)) {
                result[i] = q;
            } else {
                var lcase = caseMatchLookup.get(q.toLowerCase());
                if (lcase != null) {
                    result[i] = lcase;
                } else {
                    var pattern = vowelPatternLookup.get(toVowelPattern(q));
                    if (pattern != null) {
                        result[i] = pattern;
                    }
                }
            }
        }

        return result;
    }

    private String toVowelPattern(final String word) {
        int i = 0;
        for (; i < word.length(); i++) {
            var c = word.charAt(i);
            strBuffer[i] = VOVELS.contains(c) ? PATTERN_REPLACEMENT : Character.toLowerCase(c);
        }
        return new String(strBuffer, 0, i);
    }

}
