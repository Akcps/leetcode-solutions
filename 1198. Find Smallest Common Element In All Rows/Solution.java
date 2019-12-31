/**
 * Runtime: 34 ms, faster than 30.09% of Java online submissions for Find Smallest Common Element in All Rows.
 * Memory Usage: 64.5 MB, less than 100.00% of Java online submissions for Find Smallest Common Element in All Rows.
 */
class Solution {

    public int smallestCommonElement(int[][] mat) {
        Map<Integer, Integer> count = new HashMap<>();
        int smallest = Integer. MAX_VALUE;
        for(int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                count.put(mat[i][j], count.getOrDefault(mat[i][j], 0) + 1);
            }
        }

        int requiredCount = mat.length;
        for (int key: count.keySet()) {
            if (count.get(key) == requiredCount && key < smallest) {
                smallest = key;
            }
        }
        return smallest == Integer.MAX_VALUE ? -1: smallest;
    }
}