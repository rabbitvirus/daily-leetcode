package problem622;

public final class MyCircularQueue {

    private final int[] buffer;
    final int capacity;
    int start = 0;
    int curCnt = 0;

    public MyCircularQueue(final int k) {
        buffer = new int[k];
        capacity = k;
    }

    public boolean enQueue(final int value) {
        if (curCnt == capacity)
            return false;
        buffer[(start + curCnt++) % capacity] = value;
        return true;
    }

    public boolean deQueue() {
        if (curCnt == 0)
            return false;
        start = (start + 1) % capacity;
        --curCnt;
        return true;
    }

    public int Front() {
        return curCnt == 0 ? -1 : buffer[start];
    }

    public int Rear() {
        return curCnt == 0 ? -1 : buffer[(start + curCnt - 1) % capacity];
    }

    public boolean isEmpty() {
        return curCnt == 0;
    }

    public boolean isFull() {
        return curCnt == capacity;
    }

}
