/**
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Path Sum III.
 * Memory Usage: 39.1 MB, less than 36.54% of Java online submissions for Path Sum III.
 */
/**
 * Hint: Use Prefix Sum to track the sum.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        Map<Integer, Integer> pathCount = new HashMap<>();
        count(root, 0, targetSum, pathCount);
        return count;
    }

    private void count(TreeNode node, int currentSum, int target, Map<Integer, Integer> pathCount) {
        if (node == null) {
            return;
        }
        currentSum += node.val;

        // Sum of path starting from the root.
        if (currentSum == target) {
            count++;
        }
        // Sum of path not starting from the root.
        count += pathCount.getOrDefault(currentSum - target, 0);


        int currentSumCount = pathCount.getOrDefault(currentSum, 0);
        pathCount.put(currentSum, currentSumCount + 1);
        count(node.left, currentSum, target, pathCount);
        count(node.right, currentSum, target, pathCount);
        pathCount.put(currentSum, currentSumCount);

    }

}