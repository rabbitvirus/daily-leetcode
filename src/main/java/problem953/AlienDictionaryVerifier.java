package problem953;

import java.util.Comparator;

public final class AlienDictionaryVerifier {

    public boolean isAlienSorted(final String[] words, final String order) {
        final int wLen = words.length;
        final int[] letterWeights = new int[26];
        for (int i = 0; i < order.length(); i++) {
            letterWeights[order.charAt(i) - 'a'] = i;
        }

        final Comparator<String> comp = (o1, o2) -> {
            for (int i = 0; i < Math.min(o1.length(), o2.length()); i++) {
                final int cRes = Integer.compare(letterWeights[o1.charAt(i) - 'a'], letterWeights[o2.charAt(i) - 'a']);
                if (cRes != 0)
                    return cRes;
            }
            return Integer.compare(o1.length(), o2.length());
        };

        for (int i = 1; i < wLen; i++)
            if (comp.compare(words[i - 1], words[i]) > 0)
                return false;

        return true;
    }

}
