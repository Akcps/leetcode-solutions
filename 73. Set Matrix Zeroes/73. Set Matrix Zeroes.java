/**
 * Runtime: 1 ms, faster than 92.69% of Java online submissions for Set Matrix Zeroes.
 * Memory Usage: 40.6 MB, less than 47.40% of Java online submissions for Set Matrix Zeroes.
 * Time Complexity: O (MN)
 * Space Complexity: O(1)
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isZeroCol = false;
        boolean isZeroRow = false;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                isZeroCol = true;
            }
        }
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                isZeroRow = true;
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isZeroCol) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isZeroRow) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }
}