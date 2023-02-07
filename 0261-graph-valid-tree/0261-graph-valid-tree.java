class Solution {
    int[] parent;
    int[] rank;
    
    public boolean validTree(int n, int[][] edges) {
        // for checking valid tree
        // step 1. check for connectivity, all nodes should be reachable (use disjoinset)
        parent = new int[n];
        rank = new int[n];
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
        
        for (int[] edge: edges) {
            union(edge[0], edge[1]);
        }
        
        int parent = -1;
        for (int i = 0; i < n; i++) {
            int parentI = find(i);
            if (parent == -1) {
                parent = parentI;
            } 
            if (parent != parentI) {
                return false;
            }
        }

        // step 2. check for cycle, nodes count should be equal to n-1

        return edges.length ==  n - 1;
    }  
    
    private void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return;
        }

        if (rank[xParent] < rank[yParent]) {
            parent[xParent] = yParent;
        } else if (rank[xParent] > rank[yParent]) {
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
            rank[xParent]++;
        }
    }
    
    private int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    
}