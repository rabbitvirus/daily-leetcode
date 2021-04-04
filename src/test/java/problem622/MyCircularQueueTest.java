package problem622;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MyCircularQueueTest {

    @Test
    public void shouldRunTheCaseFromLeetCode() {
        final MyCircularQueue myCircularQueue = new MyCircularQueue(3);

        var enq1 = myCircularQueue.enQueue(1);
        assertThat(enq1, is(true));

        var enq2 = myCircularQueue.enQueue(2);
        assertThat(enq2, is(true));

        var enq3 = myCircularQueue.enQueue(3);
        assertThat(enq3, is(true));

        var enq4 = myCircularQueue.enQueue(4);
        assertThat(enq4, is(false));

        var rear1 = myCircularQueue.Rear();
        assertThat(rear1, is(3));

        var full1 = myCircularQueue.isFull();
        assertThat(full1, is(true));

        var deq1 = myCircularQueue.deQueue();
        assertThat(deq1, is(true));

        var enq5 = myCircularQueue.enQueue(4);
        assertThat(enq5, is(true));

        var rear2 = myCircularQueue.Rear();
        assertThat(rear2, is(4));
    }
}
