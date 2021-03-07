package problem706;

public final class MyHashMap {

    private int[] map = new int[8];

    /** value will always be non-negative. */
    public void put(final int key, final int value) {
        while (key >= map.length) {
            final int[] newMap = new int[2 * map.length];
            System.arraycopy(map, 0, newMap, 0, map.length);
            map = newMap;
        }
        map[key] = value + 1;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(final int key) {
        return key >= map.length || map [key] == 0 ? -1 : map[key] - 1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(final int key) {
        if (key < map.length)
            map[key] = 0;
    }

}
