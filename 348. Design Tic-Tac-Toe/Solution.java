/**
 * Runtime: 14 ms, faster than 14.01% of Java online submissions for Design Tic-Tac-Toe.
 * Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for Design Tic-Tac-Toe.
 */
class TicTacToe {

    char[][] board;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new char[n][n];
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        char c;

        if (player == 1)
            c = 'X';
        else
            c = 'O';

        board[row][col] = c;

        if (checkforWinner(row, col, player, board.length))
            return player;
        else
            return 0;
    }

    private boolean checkforWinner(int row, int col, int player, int n) {
        char c;

        if (player == 1)
            c = 'X';
        else
            c = 'O';

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (board[row][i] != c)
                flag =  false;
        }
        if (flag)
            return flag;

        flag = true;
        for (int i = 0; i < n; i++) {
            if (board[i][col] != c)
                flag = false;
        }
        if (flag)
            return flag;

        flag = true;
        for (int i = 0; i < n; i++) {
            if (board[i][i] != c)
                flag = false;
        }
        if (flag)
            return flag;

        flag = true;
        for (int i = 0; i<n; i++) {
            if (board[i][n-i-1] != c)
                flag = false;
        }
        if (flag)
            return flag;


        return false;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */