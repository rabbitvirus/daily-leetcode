package problem429;

import common.Node;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public final class NaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(final Node root) {
        final List<List<Integer>> trav = new LinkedList<>();
        if (root == null)
            return trav;

        final Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            final int levelLen = q.size();
            final List<Integer> lev = new LinkedList<>();

            for (int i = 0; i < levelLen; i++) {
                final Node n = q.poll();
                lev.add(n.val);
                if (n.children != null) {
                    for (var c : n.children) {
                        q.offer(c);
                    }
                }
            }

            trav.add(lev);
        }

        return trav;
    }

}
