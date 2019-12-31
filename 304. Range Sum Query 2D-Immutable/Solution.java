/**
 *  Runtime: 14 ms, faster than 91.54% of Java online submissions for Range Sum Query 2D - Immutable.
 * Memory Usage: 43.1 MB, less than 100.00% of Java online submissions for Range Sum Query 2D - Immutable.
 */
class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
class NumMatrix {

    int[][] dp;

    public NumMatrix(int[][] matrix) {
        int row = 0;
        int col = 0;
        if (matrix.length != 0) {
            row = matrix.length;
            col = matrix[0].length;
        }
        dp = new int[row + 1][col + 1];

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + matrix[i-1][j-1] - dp[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return dp[row2+1][col2+1] - dp[row1][col2+1] - dp[row2+1][col1] + dp[row1][col1];
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */