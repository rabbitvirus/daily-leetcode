package common;

import java.util.List;

public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(final int val) {
        this.val = val;
    }

    public Node(final int val, final List<Node> children) {
        this.val = val;
        this.children = children;
    }
}
