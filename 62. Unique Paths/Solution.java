/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 * Memory Usage: 36.5 MB, less than 5.10% of Java online submissions for Unique Paths.
 */
class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++)
            paths[i][0] = 1;
        for (int i = 0; i < n; i++)
            paths[0][i] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i-1][j] + paths[i][j-1];
            }
        }

        return paths[m-1][n-1];
    }
}