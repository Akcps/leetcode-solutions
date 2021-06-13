public class WeightedQuickUnionWithPathCompression implements UnionFind {
    private int[] id;
    private int[] size;

    public WeightedQuickUnionWithPathCompression(int n) {
        id = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    private int root(int i) {
        while (id[i] != i) {
            id[i] = id[id[i]]; // path compression
            i = id[i];
        }
        return i;
    }

    public void union(int p, int q) {
        int parentP = root(p);
        int parentQ = root(q);
        if (parentP == parentQ)
            return;
        if (size[parentP] < size[parentQ]) {
            id[parentP] = parentQ;
            size[parentQ] += size[parentP]
        } else {
            id[parentQ] = parentP;
            size[parentP] += size[parentQ]
        }
    }


    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }
}
