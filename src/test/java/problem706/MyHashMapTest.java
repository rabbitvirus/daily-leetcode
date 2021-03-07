package problem706;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyHashMapTest {

    private MyHashMap map = new MyHashMap();

    @Test
    public void shouldRunLeetCodeExample() {
        map.put(1, 1);
        map.put(2, 2);

        var n1 = map.get(1);
        assertThat(n1, is(1));

        var n3 = map.get(3);
        assertThat(n3, is(-1));

        map.put(2, 1);
        var n21 = map.get(2);
        assertThat(n21, is(1));

        map.remove(2);
        var n22 = map.get(2);
        assertThat(n22, is(-1));
    }

}
