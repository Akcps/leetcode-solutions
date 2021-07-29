/**
 * Runtime: 15 ms, faster than 49.71% of Java online submissions for 01 Matrix.
 * Memory Usage: 42.8 MB, less than 39.68% of Java online submissions for 01 Matrix.
 * Time Complexity: O (R*C)
 * Space Complexity: O (R*C)
 */
class Solution {
    private int[] dr = new int[] {-1, 1, 0, 0};
    private int[] dc = new int[] { 0, 0, -1, 1};
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0)
            return mat;
        int[][] res = new int[mat.length][mat[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    res[i][j] = Integer.MAX_VALUE;
                } else {
                    res[i][j] = 0;
                    queue.add(new int[]{ i, j});
                }

            }
        }
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = dr[i] + current[0];
                int newC = dc[i] + current[1];
                if (newR >= 0 && newR < mat.length && newC >= 0 && newC < mat[0].length) {
                    if (res[newR][newC] > res[current[0]][current[1]] + 1) {
                        res[newR][newC] = res[current[0]][current[1]] + 1;
                        queue.add(new int[] {newR, newC});
                    }
                }
            }


        }
        return res;
    }
}

/**
 * Runtime: 5 ms, faster than 99.70% of Java online submissions for 01 Matrix.
 * Memory Usage: 42.4 MB, less than 55.34% of Java online submissions for 01 Matrix.
 * Time Complexity: O (R*C)
 * Space Complexity: O (1)
 */
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat.length == 0)
            return mat;
        int[][] res = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[i][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] != 0) {
                    if (i > 0) {
                        res[i][j] = Math.min(res[i][j], res[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        res[i][j] = Math.min(res[i][j], res[i][j - 1] + 1);
                    }
                } else {
                    res[i][j] = 0;
                }
            }
        }

        for (int i = mat.length - 1; i >= 0; i--) {
            for (int j = mat[0].length - 1; j >= 0 ; j--) {
                if (i < mat.length - 1) {
                    res[i][j] = Math.min(res[i][j], res[i + 1][j] + 1);
                }
                if (j < mat[0].length - 1) {
                    res[i][j] = Math.min(res[i][j], res[i][j + 1] + 1);
                }
            }
        }
        return res;
    }
}