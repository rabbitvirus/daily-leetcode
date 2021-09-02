package problem95;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public final class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(final int n) {
        return (n == 1) ? List.of(new TreeNode(1)) : generate(1, n);
    }

    private List<TreeNode> generate(final int from, final int to) {
        final List<TreeNode> res = new ArrayList<>();
        if (from > to) {
            res.add(null);
            return res;
        }

        for (int i = from; i <= to; i++) {
            for (var ln : generate(from, i - 1)) {
                for (var rn : generate(i + 1, to)) {
                    res.add(new TreeNode(i, ln, rn));
                }
            }
        }

        return res;
    }

}
