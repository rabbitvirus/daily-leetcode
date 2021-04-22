package problem554;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class BrickWall {

    public int leastBricks(final List<List<Integer>> wall) {
        final int h = wall.size();

        int w = 0;
        for (var b : wall.get(0))
            w += b;

        final Map<Integer, Integer> gaps = new HashMap<>();
        for (var row : wall) {
            int tot = 0;
            for (var l : row) {
                tot += l;
                if (tot == w)
                    break;

                final int pos = tot - 1;
                gaps.put(pos, gaps.getOrDefault(pos, 0) + 1);
            }
        }

        int max = -1;
        for (int g : gaps.values())
            if (g > max)
                max = g;

        return gaps.isEmpty() ? h : h - max;
    }

}
