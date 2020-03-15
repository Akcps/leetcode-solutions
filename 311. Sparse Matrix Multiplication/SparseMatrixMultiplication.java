/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sparse Matrix Multiplication.
 * Memory Usage: 41.6 MB, less than 7.14% of Java online submissions for Sparse Matrix Multiplication.
 */
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 0) {
                    continue;
                }
                for (int k = 0; k < B[0].length; k++) {
                    int temp = A[i][j] * B[j][k];
                    result[i][k] += temp;
                }
            }
        }
        return result;
    }
}