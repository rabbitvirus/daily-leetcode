package problem630;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class CourseSchedule3Test {

    private CourseSchedule3 solution = new CourseSchedule3();

    @DataProvider(name = "dp1")
    private static Object[][] provideData() {
        return new Object[][]{
                {new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}}, 3},
                {new int[][]{{1, 2}}, 1},
                {new int[][]{{3, 2}, {4, 3}}, 0},
                {new int[][]{{5, 11}, {3, 5}, {10, 20}, {4, 20}, {10, 16}}, 3},
                {new int[][]{{5, 5}, {4, 6}, {2, 6}}, 2}
        };
    }

    @Test(dataProvider = "dp1")
    public void shouldFindMaxNumberOfCourses(final int[][] courses, final int expMax) {
        var actMax = solution.scheduleCourse(courses);

        assertThat(expMax, is(actMax));
    }

}
