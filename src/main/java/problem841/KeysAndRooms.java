package problem841;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class KeysAndRooms {

    public boolean canVisitAllRooms(final List<List<Integer>> rooms) {
        if (rooms.size() == 1) return true;

        final List<List<Integer>> roomsArr = rooms instanceof ArrayList ? rooms : new ArrayList<>(rooms);
        final boolean[] visited = new boolean[rooms.size()];

        final Queue<Integer> q = new LinkedList<>();
        visited[0] = true;
        int toVisit = visited.length - 1;

        for (final int r : roomsArr.get(0)) {
            if (r != 0)
                q.offer(r);
        }

        while (!q.isEmpty()) {
            int cr = q.poll();
            if (visited[cr])
                continue;

            visited[cr] = true;
            if (--toVisit == 0) return true;

            for (final int r : roomsArr.get(cr)) {
                if (!visited[r])
                    q.offer(r);
            }
        }

        return false;
    }

}
