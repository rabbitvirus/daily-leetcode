package problem89;

import java.util.ArrayList;
import java.util.List;

public final class GrayCode {

    public List<Integer> grayCode(final int n) {
        final int size = 1 << n;
        final List<Integer> seq = new ArrayList<>(size);

        for (int i = 0; i < size; i++)
            seq.add(i ^ (i >> 1));

        return seq;
    }

}
