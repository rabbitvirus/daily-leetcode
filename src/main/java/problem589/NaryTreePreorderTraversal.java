package problem589;

import common.Node;

import java.util.LinkedList;
import java.util.List;

public final class NaryTreePreorderTraversal {

    public List<Integer> preorder(final Node root) {
        final List<Integer> ll = new LinkedList<>();
        if (root != null)
            recHelper(root, ll);
        return ll;
    }

    private void recHelper(final Node root, final List<Integer> travList) {
        travList.add(root.val);

        for (var ch : root.children)
            if (ch != null)
                recHelper(ch, travList);
    }

}
