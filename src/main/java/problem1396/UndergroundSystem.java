package problem1396;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class UndergroundSystem {

    private final Map<Integer, PairVal<String, Integer>> checkInTimeLookup = new HashMap<>();
    private final Map<String, Map<String, List<Integer>>> totalTripTimesMap = new HashMap<>();

    public void checkIn(final int id, final String stationName, final int t) {
        checkInTimeLookup.put(id, new PairVal<>(stationName, t));
    }

    public void checkOut(final int id, final String stationName, final int t) {
        var p = checkInTimeLookup.get(id);
        totalTripTimesMap.computeIfAbsent(p.v1, k -> new HashMap<>()).computeIfAbsent(stationName, k -> new ArrayList<>()).add(t - p.v2);
    }

    public double getAverageTime(final String startStation, final String endStation) {
        var times = totalTripTimesMap.get(startStation).get(endStation);
        int tot = 0;
        for (final int t : times)
            tot += t;
        return (double) tot / times.size();
    }

    private static final class PairVal<V1, V2> {
        private final V1 v1;
        private final V2 v2;

        PairVal(final V1 v1, final V2 v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

}
