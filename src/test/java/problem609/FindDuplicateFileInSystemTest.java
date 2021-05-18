package problem609;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindDuplicateFileInSystemTest {

    private FindDuplicateFileInSystem solution = new FindDuplicateFileInSystem();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {
                        new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"},
                        List.of(List.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), List.of("root/a/1.txt", "root/c/3.txt"))
                },
                {
                        new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"},
                        List.of(List.of("root/a/2.txt", "root/c/d/4.txt"), List.of("root/a/1.txt", "root/c/3.txt"))
                }
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindDuplicatedFiles(final String[] files, final List<List<String>> expDups) {
        var actDups = solution.findDuplicate(files);

        assertThat(actDups, is(expDups));
    }
}
