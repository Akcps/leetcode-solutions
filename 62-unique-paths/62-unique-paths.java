class Solution {
    public int uniquePaths(int m, int n) {
        int[][] moves = new int[m][n];
        int[] dx = new int[] {0, 1};
        int[] dy = new int[] {1, 0};
        moves[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) {
                    moves[i][j] += moves[i - 1][j];
                }
                if (j > 0) {
                     moves[i][j] += moves[i][j - 1];
                }
            }
        }
        return moves[m - 1] [n - 1];
    }
}