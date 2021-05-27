package problem65;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ValidNumberTest {

    private ValidNumber solution = new ValidNumber();

    @DataProvider(name = "validNumbers")
    private static Object[][] provideValidNumbers() {
        return List.of("2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789")
                .stream()
                .map(e -> new Object[]{e})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "invalidNumbers")
    private static Object[][] provideInvalidNumbers() {
        return List.of("abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53")
                .stream()
                .map(e -> new Object[]{e})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "validNumbers")
    public void shouldDetectValidNumbers(final String validNum) {
        var isValid = solution.isNumber(validNum);

        assertThat(isValid, is(true));
    }

    @Test(dataProvider = "invalidNumbers")
    public void shouldDetectInvalidNumbers(final String invalidNum) {
        var isValid = solution.isNumber(invalidNum);

        assertThat(isValid, is(false));
    }

}
