/**
 * Runtime: 9 ms, faster than 5.86% of Java online submissions for Queens That Can Attack the King.
 * Memory Usage: 42.9 MB, less than 100.00% of Java online submissions for Queens That Can Attack the King.
 */
class Solution {
    int[] DIR_X = new int[] {-1, 1, -1, 1, 0, 0, -1, 1};
    int[] DIR_Y = new int[] {-1, 1, 1, -1, 1, -1, 0, 0};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        if (queens == null || queens.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> attackingQueens = new ArrayList<>();
        Map<String, List<Integer>> queensMap = new HashMap<>();
        for (int[] queen:queens) {
            String key = queen[0] + "," + queen[1];
            List<Integer> value = new ArrayList<>();
            value.add(queen[0]);
            value.add(queen[1]);
            queensMap.put(key, value);
        }
        for (int i = 0; i < 8; i++) {
            int x = king[0] + DIR_X[i];
            int y = king[1] + DIR_Y[i];
            while (isInsideLimit(x, y)) {
                String key = x + "," + y;
                if (queensMap.containsKey(key)) {
                    attackingQueens.add(queensMap.get(key));
                    break;
                }
                x += DIR_X[i];
                y += DIR_Y[i];
            }
        }
        return attackingQueens;
    }

    private boolean isInsideLimit(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
}