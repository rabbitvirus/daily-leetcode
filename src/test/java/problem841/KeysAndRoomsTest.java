package problem841;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class KeysAndRoomsTest {

    private KeysAndRooms solution = new KeysAndRooms();

    @DataProvider(name = "dp1")
    public static Object[][] provideData() {
        return new Object[][]{
                {Arrays.asList(
                        Collections.singletonList(1),
                        Collections.singletonList(2),
                        Collections.singletonList(3),
                        Collections.emptyList()
                ), true},

                {Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(3, 0, 1),
                        Collections.singletonList(2),
                        Collections.singletonList(0)
                ), false}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfCanVisitAllRooms(final List<List<Integer>> roomsGraph, final boolean expCanVisit) {
        final boolean actCanVisit = solution.canVisitAllRooms(roomsGraph);

        assertThat(actCanVisit, is(expCanVisit));
    }
}
