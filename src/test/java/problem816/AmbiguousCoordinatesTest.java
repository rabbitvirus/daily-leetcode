package problem816;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AmbiguousCoordinatesTest {

    private AmbiguousCoordinates solution = new AmbiguousCoordinates();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {"(123)", List.of("(1, 2.3)", "(1, 23)", "(1.2, 3)", "(12, 3)")},
                {"(0123)", List.of("(0, 1.23)", "(0, 12.3)", "(0, 123)", "(0.1, 2.3)", "(0.1, 23)", "(0.12, 3)")},
                {"(00011)", List.of("(0, 0.011)", "(0.001, 1)")},
                {"(100)", List.of("(10, 0)")},
                {"(0110)", List.of("(0, 110)", "(0.1, 10)", "(0.11, 0)")}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindAllPossibleCoordinates(final String str, final List<String> expCoordinates) {
        var actCoordinates = solution.ambiguousCoordinates(str);

        assertThat(new HashSet<>(actCoordinates), is(new HashSet<>(expCoordinates)));
    }

}
