class Solution {
    private int[] dr = new int[]{0, 0, 1, -1};
    private int[] dc = new int[]{1, -1, 0, 0};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int row = dr[i] + current[0];
                int col = dc[i] + current[1];
                if (row >= 0 && row < rooms.length && col >= 0 && col < rooms[0].length && rooms[row][col] == Integer.MAX_VALUE) {
                    rooms[row][col] = rooms[current[0]][current[1]] + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }

    }
}