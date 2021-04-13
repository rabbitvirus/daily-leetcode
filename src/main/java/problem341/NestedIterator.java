package problem341;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class NestedIterator implements Iterator<Integer> {

    private final LinkedList<Iterator<NestedInteger>> iterStack = new LinkedList<>();
    private Integer next;

    public NestedIterator(final List<NestedInteger> nestedList) {
        iterStack.add(nestedList.iterator());
        findNext();
    }

    @Override
    public Integer next() {
        var n = next;
        findNext();
        return n;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    private void findNext() {
        while (!iterStack.isEmpty()) {
            var it = iterStack.getLast();
            if (it.hasNext()) {
                var n = it.next();
                if (n.isInteger()) {
                    next = n.getInteger();
                    return;
                } else {
                    iterStack.add(n.getList().iterator());
                }
            } else {
                iterStack.removeLast();
            }
        }

        next = null;
    }

}
