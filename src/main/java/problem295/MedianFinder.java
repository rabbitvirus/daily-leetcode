package problem295;

import java.util.PriorityQueue;
import java.util.Queue;

public final class MedianFinder {

    private final Queue<Integer> minQ = new PriorityQueue<>();
    private final Queue<Integer> maxQ = new PriorityQueue<>((a, b) -> b - a);

    public void addNum(final int num) {
        if (maxQ.isEmpty() || maxQ.peek() > num)
            maxQ.offer(num);
        else
            minQ.offer(num);

        if (maxQ.size() - minQ.size() == 2)
            minQ.offer(maxQ.poll());
        else if (minQ.size() > maxQ.size())
            maxQ.offer(minQ.poll());
    }

    public double findMedian() {
        return minQ.size() == maxQ.size() ? (maxQ.peek() + minQ.peek()) / 2.0d : (double) maxQ.peek();
    }

}
