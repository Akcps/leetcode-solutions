/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Toeplitz Matrix.
 * Memory Usage: 43.1 MB, less than 83.87% of Java online submissions for Toeplitz Matrix.
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i-1][j-1] != matrix[i][j])
                    return false;
            }
        }
        return true;
    }
}