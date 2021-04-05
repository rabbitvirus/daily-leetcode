package problem859;

public final class BuddyStrings {

    public boolean buddyStrings(final String a, final String b) {
        if (a.length() != b.length())
            return false;

        final int[] diffPosLookup = new int[2];
        int posIdx = 0;

        boolean hasDups = a.length() > 'z' - 'a' + 1;
        final boolean[] dupLookup = hasDups ? null : new boolean['z' - 'a' + 1];


        for (int i = 0; i < a.length(); i++) {
            var ac = a.charAt(i);
            if (!hasDups) {
                var idx = ac - 'a';
                hasDups = dupLookup[idx];
                dupLookup[idx] = true;
            }

            if (ac != b.charAt(i)) {
                if (posIdx >= 2)
                    return false;
                diffPosLookup[posIdx++] = i;
            }
        }

        return (posIdx == 0 && hasDups) ||
                (posIdx == 2 && a.charAt(diffPosLookup[0]) == b.charAt(diffPosLookup[1]) && a.charAt(diffPosLookup[1]) == b.charAt(diffPosLookup[0]));
    }

}
