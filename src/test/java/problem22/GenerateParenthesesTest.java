package problem22;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class GenerateParenthesesTest {

    private GenerateParentheses solution = new GenerateParentheses();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {3, Set.of("((()))", "(()())", "(())()", "()(())", "()()()")},
                {1, Set.of("()")}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldGenerateParentheses(final int n, final Set<String> expSet) {
        var actList = solution.generateParenthesis(n);

        assertThat(new HashSet<>(actList), is(expSet));
    }

}
