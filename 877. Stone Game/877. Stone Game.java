/**
 * Runtime: 13 ms, faster than 20.67% of Java online submissions for Stone Game.
 * Memory Usage: 39.3 MB, less than 49.05% of Java online submissions for Stone Game.
 * Time Complexity: O (N ^ 2)
 * Space Complexity: O (N ^ 2)
 */

class Solution {
    int[][] mem;
    public boolean stoneGame(int[] piles) {
        mem = new int[piles.length + 1][piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
            for (int j = 0; j < piles.length; j++) {
                mem[i][j] = -1;
            }
        }
        return maxStone(piles, 0, piles.length -1) > 0;
    }

    private int maxStone(int[] piles, int left, int right) {
        if (left == right) {
            return piles[left];
        }

        if(mem[left][right] != -1) {
            return mem[left][right];
        }
        mem[left][right] = Math.max(maxStone(piles, left + 1, right), maxStone(piles, left, right -1));
        return mem[left][right];

    }
}