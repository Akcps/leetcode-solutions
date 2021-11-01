/**
 * Runtime: 2 ms, faster than 71.56% of Java online submissions for Surrounded Regions.
 * Memory Usage: 41 MB, less than 82.91% of Java online submissions for Surrounded Regions.
 */

class Solution {
    int rows;
    int cols;
    int[] dx = new int[]{-1, 1, 0, 0};
    int[] dy = new int[]{0, 0, -1, 1};

    public void solve(char[][] board) {

        if (board == null || board.length == 0) {
            return;
        }

        rows = board.length;
        cols = board[0].length;

        //bfs for all corners
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                bfs(board, i, 0);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                bfs(board, 0, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            if (board[i][cols - 1] == 'O') {
                bfs(board, i, cols - 1);
            }
        }

        for (int j = 0; j < cols; j++) {
            if (board[rows - 1][j] == 'O') {
                bfs(board, rows - 1, j);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(char[][] board, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            board[point[0]][point[1]] = '1';
            for (int c = 0; c < 4; c++) {
                int row = point[0] + dx[c];
                int col = point[1] + dy[c];
                if (row >= 0 && row < rows && col >= 0 && col < cols && board[row][col] == 'O') {
                    board[row][col] = '1';
                    queue.add(new int[]{row, col});
                }
            }
        }

    }
}