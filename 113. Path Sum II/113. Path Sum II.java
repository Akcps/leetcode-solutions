/**
 * Runtime: 1 ms, faster than 99.91% of Java online submissions for Path Sum II.
 * Memory Usage: 39.6 MB, less than 44.61% of Java online submissions for Path Sum II.
 * Time Complexity: O(N)
 * Space Complexity: O (N)
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

    List<List<Integer>> results = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return results;
        }
        sum(root, new ArrayList<>(), targetSum);
        return results;
    }

    private void sum (TreeNode node, List<Integer> paths, int targetSum) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null && targetSum != node.val) {
            return;
        }
        paths.add(node.val);
        if (node.val == targetSum && node.left == null && node.right == null) {
            results.add(new ArrayList(paths));
            paths.remove(paths.size() - 1);
            return;
        }
        sum(node.left, paths, targetSum - node.val);
        sum(node.right, paths, targetSum - node.val);

        paths.remove(paths.size() - 1);

    }
}