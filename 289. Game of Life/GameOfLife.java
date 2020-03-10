/**
 * Runtime: 1 ms, faster than 20.83% of Java online submissions for Game of Life.
 * Memory Usage: 38.4 MB, less than 7.69% of Java online submissions for Game of Life.
 */
class Solution {
    int[] X_DIR = new int[] { 0, 0, 1, 1, 1, -1, -1, -1 };
    int[] Y_DIR = new int[] { -1, 1, 1, -1, 0, 1, -1, 0 };
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        ZeroOne[][] zeroOnes = new ZeroOne[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                zeroOnes[i][j] = new ZeroOne();
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                calculateCount(board, zeroOnes, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 0 && zeroOnes[i][j].ones == 3) {
                    board[i][j] = 1;
                } else if (board[i][j] == 1 && zeroOnes[i][j].ones < 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 1 && zeroOnes[i][j].ones > 3) {
                    board[i][j] = 0;
                } else if (board[i][j] == 1 && (zeroOnes[i][j].ones == 2 || zeroOnes[i][j].ones == 3)) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
    }

    private void calculateCount(int[][] board, ZeroOne[][] zeroOnes, int x, int y) {
        for (int i = 0; i < 8; i++) {
            int newX = x + X_DIR[i];
            int newY = y + Y_DIR[i];
            if (insideBounds(newX, newY, board.length, board[0].length)) {
                if (board[newX][newY] == 0) {
                    zeroOnes[x][y].zeros++;
                } else {
                    zeroOnes[x][y].ones++;
                }
            }
        }

    }

    private boolean insideBounds(int x, int y, int X, int Y) {
        if (x < 0 || x >= X || y < 0 || y >= Y) {
            return false;
        }
        return true;
    }

    class ZeroOne {
        int zeros;
        int ones;
        public ZeroOne() {
            zeros = 0;
            ones = 0;
        }
    }
}