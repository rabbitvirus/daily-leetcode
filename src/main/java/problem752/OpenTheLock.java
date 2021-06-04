package problem752;

import java.util.LinkedList;
import java.util.Queue;

public final class OpenTheLock {

    public int openLock(final String[] deadends, final String target) {
        final boolean[] deads = new boolean[10000];
        final boolean[] visited = new boolean[10000];

        for (var d : deadends)
            deads[strToInt(d)] = true;

        final int t = strToInt(target);
        final Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!q.isEmpty()) {
            var qLen = q.size();

            for (int p = 0; p < qLen; p++) {
                var cur = q.poll();

                if (cur == t)
                    return steps;

                if (deads[cur])
                    continue;

                for (int i = 0; i < 4; i++) {

                    var inc = modCharAt(cur, i, true);
                    if (!visited[inc]) {
                        q.offer(inc);
                        visited[inc] = true;
                    }

                    var dec = modCharAt(cur, i, false);
                    if (!visited[dec]) {
                        q.offer(dec);
                        visited[dec] = true;
                    }
                }
            }

            steps++;
        }

        return -1;
    }

    private int strToInt(final String str) {
        int num = 0;
        for (int i = 0; i < 4; i++)
            num = 10 * num + str.charAt(i) - '0';
        return num;
    }

    private int modCharAt(final int num, final int pos, final boolean inc) {
        int n2 = num;
        int div = 1;
        for (int i = 0; i < pos; i++) {
            div *= 10;
            n2 /= 10;
        }

        int rep = n2 % 10;
        n2 /= 10;

        if (inc)
            rep = (rep + 1) % 10;
        else
            rep = rep == 0 ? 9 : rep - 1;

        n2 *= 10;
        n2 += rep;

        for (int i = 0; i < pos; i++)
            n2 *= 10;

        n2 += num % div;

        return n2;
    }

}
