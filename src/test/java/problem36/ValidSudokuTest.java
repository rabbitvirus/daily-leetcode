package problem36;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ValidSudokuTest {

    private ValidSudoku solution = new ValidSudoku();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {
                        new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}},
                        true
                },
                {
                        new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}},
                        false
                }
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldCheckIfSudokuIsValid(final char[][] board, final boolean expAnswer) {
        var actAnswer = solution.isValidSudoku(board);

        assertThat(actAnswer, is(expAnswer));
    }

}
