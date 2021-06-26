package problem684;

public final class RedundantConnection {

    public int[] findRedundantConnection(final int[][] edges) {
        final int n = edges.length;

        final int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (final int[] e : edges) {
            if (unionCheck(parent, e[0] - 1, e[1] - 1))
                return e;
        }

        return null;
    }

    private boolean unionCheck(final int[] parent, final int n1, final int n2) {
        final int n1Root = findRoot(parent, n1);
        final int n2Root = findRoot(parent, n2);

        if (n1Root == n2Root)
            return true;

        parent[n2Root] = n1Root;
        return false;
    }

    private int findRoot(final int[] parent, int node) {
        while (node != parent[node])
            node = parent[node];
        return node;
    }
}
