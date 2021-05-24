package problem709;

public final class ToLowerCase {

    public String toLowerCase(final String s) {
        final StringBuilder sb = new StringBuilder(s.length());

        for (int i = 0; i < s.length(); i++) {
            var c = s.charAt(i);
            sb.append('A' <= c && c <= 'Z' ? (char) (c - 'A' + 'a') : c);
        }

        return sb.toString();
    }

}
