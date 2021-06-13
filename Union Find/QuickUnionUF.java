public class QuickUnionUF implements UnionFind{
    private int[] id;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            i = id[i];
        }
        return i;
    }

    // O(N)
    public void union(int p, int q) {
        int parentP = root(p);
        int parentQ = root(q);
        if (parentP == parentQ)
            return;
        id[parentP] = parentQ;
    }

    // O(N)
    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}