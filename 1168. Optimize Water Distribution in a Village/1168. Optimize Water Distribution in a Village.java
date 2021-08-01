/**
 * Runtime: 26 ms, faster than 67.02% of Java online submissions for Optimize Water Distribution in a Village.
 * Memory Usage: 44.3 MB, less than 76.52% of Java online submissions for Optimize Water Distribution in a Village.
 *
 * Let N be the number of houses, and M be the number of pipes from the input.
 * Time Complexity: O((N+M)⋅log(N+M))
 * Space Complexity: O(N+M)
 *
 */
class Solution {
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        DSU dsu = new DSU(n);
        Queue<int[]> queue = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);

        for (int i = 0 ; i < wells.length; i++) {
            queue.add(new int[] {0, i + 1, wells[i]});
        }

        for (int i = 0; i < pipes.length; i++) {
            queue.add(pipes[i]);
        }

        int cost = 0;
        while(!queue.isEmpty()) {
            int[] polled = queue.poll();
            if (!dsu.isConnected(polled[0], polled[1])) {
                dsu.union(polled[0], polled[1]);
                cost += polled[2];
            }
        }
        return cost;
    }


    class DSU {
        private int[] id;
        private int[] size;

        public DSU(int n) {
            id = new int[n + 1];
            size = new int[n + 1];
            for (int i = 0; i <= n; i++) {
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
                size[parentQ] += size[parentP];
            } else {
                id[parentQ] = parentP;
                size[parentP] += size[parentQ];
            }
        }

        public boolean isConnected(int p, int q) {
            return root(p) == root(q);
        }
    }
}