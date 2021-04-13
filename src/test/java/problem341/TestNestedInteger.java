package problem341;

import java.util.List;

final class TestNestedInteger implements NestedInteger {

    private final Integer singleInt;
    private final List<NestedInteger> intsList;

    private TestNestedInteger(final Integer singleInt, final List<NestedInteger> intsList) {
        this.singleInt = singleInt;
        this.intsList = intsList;
    }

    static NestedInteger singleInteger(final int singleInt) {
        return new TestNestedInteger(singleInt, null);
    }

    static NestedInteger listInteger(final List<NestedInteger> intsList) {
        return new TestNestedInteger(null, intsList);
    }

    @Override
    public boolean isInteger() {
        return singleInt != null;
    }

    @Override
    public Integer getInteger() {
        return singleInt;
    }

    @Override
    public List<NestedInteger> getList() {
        return intsList;
    }
}
