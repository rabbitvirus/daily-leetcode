package problem971;

import common.TreeNode;

import java.util.LinkedList;
import java.util.List;

public final class BinaryTreeFlip {

    private static final List<Integer> IMPOSSIBLE_FLIP = List.of(-1);

    private int i = 0;

    public List<Integer> flipMatchVoyage(final TreeNode root, final int[] voyage) {
        if (root.val != voyage[0]) return IMPOSSIBLE_FLIP;

        final List<Integer> flips = new LinkedList<>();
        goWithFlips(root, voyage, flips);
        return i == -1 ? IMPOSSIBLE_FLIP : flips;
    }

    private void goWithFlips(final TreeNode root, final int[] voyage, final List<Integer> flips) {
        if (i == -1 || root == null || i >= voyage.length) return;

        if (root.val != voyage[i++]) {
            i = -1;
            return;
        }

        if (i >= voyage.length) return;

        if (root.left != null && root.left.val != voyage[i]) {
            flips.add(root.val);
            goWithFlips(root.right, voyage, flips);
            goWithFlips(root.left, voyage, flips);
        } else {
            goWithFlips(root.left, voyage, flips);
            goWithFlips(root.right, voyage, flips);
        }
    }

}
