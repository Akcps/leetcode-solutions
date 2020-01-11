/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 4 ms, faster than 48.13% of Java online submissions for Deepest Leaves Sum.
 * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Deepest Leaves Sum.
 */
class Solution {
    public int deepestLeavesSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        return bfs(queue);
    }

    private int bfs(Queue<TreeNode> queue) {
        int currentLevelSum = 0;
        while (!queue.isEmpty()) {
            currentLevelSum = 0;
            int size = queue.size();
            for (int i = 0 ; i < size; i++) {
                TreeNode polled = queue.poll();
                currentLevelSum += polled.val;
                if (polled.left != null) {
                    queue.add(polled.left);
                }
                if (polled.right != null) {
                    queue.add(polled.right);
                }
            }
        }
        return currentLevelSum;
    }
}