class Solution {
    int[] r = new int[] { -1, 0, 0, 1 }; 
    int[] c = new int[] { 0, -1, 1, 0 };
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldColor = image[sr][sc];
        if (oldColor == color) {
            return image;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {sr,sc});
        while(!queue.isEmpty()) {
           int[] current = queue.poll();
           image[current[0]][current[1]] = color;
            for (int i = 0; i < 4; i++) {
                int newRow = current[0] + r[i];
                int newCol = current[1] + c[i];
                if (newRow >= 0 && newCol >= 0 && newRow < image.length && newCol < image[0].length && image[newRow][newCol] == oldColor) {
                    queue.add(new int[] {newRow,newCol});
                }
            }
        }
        return image;
        
    }
}