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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 * Memory Usage: 38.8 MB, less than 33.33% of Java online submissions for Closest Binary Search Tree Value.
 */
class Solution {
    public int closestValue(TreeNode root, double target) {
        Stack<TreeNode> stack = new Stack();
        long predecessor = Long.MIN_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();

            if (predecessor <= target && target < root.val)
                return Math.abs(predecessor - target) < Math.abs(root.val - target) ? (int)predecessor : root.val;

            predecessor = root.val;
            root = root.right;
        }
        return (int)predecessor;
    }

}

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Closest Binary Search Tree Value.
 * Memory Usage: 39 MB, less than 30.16% of Java online submissions for Closest Binary Search Tree Value.
 */

class Solution {
    int closest = -1;
    double diff = Double.MAX_VALUE;

    public int closestValue(TreeNode root, double target) {
        findDiff(root, target);
        return closest;
    }

    private void findDiff(TreeNode node, double target) {
        if (node == null) {
            return;
        }
        double currentDiff = Math.abs(node.val - target);
        if (diff > currentDiff) {
            closest = node.val;
            diff = currentDiff;
        }
        findDiff(node.left, target);
        findDiff(node.right, target);
    }
}