package problem729;

import java.util.TreeMap;

public final class MyCalendar {

    private final TreeMap<Integer, Integer> intervalLookup = new TreeMap<>();

    public boolean book(final int start, final int end) {
        var startFloor = intervalLookup.floorEntry(start);
        if (startFloor != null && startFloor.getValue() > start)
            return false;

        var startCeil = intervalLookup.ceilingKey(start);
        if (startCeil != null && startCeil < end)
            return false;

        intervalLookup.put(start, end);
        return true;
    }

}
