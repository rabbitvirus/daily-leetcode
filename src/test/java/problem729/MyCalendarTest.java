package problem729;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyCalendarTest {

    @Test
    public void shouldRunTheCalendar() {
        var cal = new MyCalendar();

        var booking1 = cal.book(10, 20);
        assertThat(booking1, is(true));

        var booking2 = cal.book(15, 25);
        assertThat(booking2, is(false));

        var booking3 = cal.book(20, 30);
        assertThat(booking3, is(true));
    }

}
