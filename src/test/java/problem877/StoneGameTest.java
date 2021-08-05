package problem877;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class StoneGameTest {

    @Test
    public void shouldCheckIfAlexCanWin() {
        var solution = new StoneGame();

        var canWin = solution.stoneGame(new int[]{5, 3, 4, 5});

        assertThat(canWin, is(true));
    }

}
