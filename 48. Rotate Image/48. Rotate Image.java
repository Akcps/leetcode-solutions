/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 * Memory Usage: 39.4 MB, less than 13.47% of Java online submissions for Rotate Image.
 */

class Solution {
    // (0,0) -> (0,n-1)  (0,1) -> (1, n-1)  (0, 2) -> (2, n-1) (0, 3) -> (3, n-1)
    // (0, n-1) -> (n-1, n-1)  (1, n-1) -> (n-2, n-1) ...
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 - i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }
}