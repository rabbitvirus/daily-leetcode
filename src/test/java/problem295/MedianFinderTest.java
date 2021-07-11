package problem295;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MedianFinderTest {

    @Test
    public void shouldAddNumsAndFindMedians() {
        var medianFinder = new MedianFinder();

        medianFinder.addNum(1);
        medianFinder.addNum(2);

        var med1 = medianFinder.findMedian();
        assertThat(med1, is(1.5d));

        medianFinder.addNum(3);

        var med2 = medianFinder.findMedian();
        assertThat(med2, is(2.0d));
    }

}
