public class QuickFindUF implements UnionFind{
    private int[] id;

    public QuickFindUF(int n){
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    // O(N)
    public void union (int p, int q) {
        int parentP = id[p];
        int parentQ = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == parentP) {
                id[i] = parentQ;
            }
        }
    }

    //O(1)
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }
}