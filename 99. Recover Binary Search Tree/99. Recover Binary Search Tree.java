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

/**
    Runtime: 3 ms, faster than 41.50% of Java online submissions for Recover Binary Search Tree.
    Memory Usage: 39.2 MB, less than 63.36% of Java online submissions for Recover Binary Search Tree.
 */
class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode x = null,y = null, pred = null, current = root;

        while(!stack.isEmpty() || current != null) {

            while (current!= null) {
                stack.add(current);
                current = current.left;
            }
            current = stack.pop();
            if (pred != null && pred.val > current.val) {
                y = current;
                if (x == null) {
                    x = pred;
                } else {
                    break;
                }
            }
            pred = current;
            current = current.right;
        }
        swapTreeNodes(x, y);
    }

    private void swapTreeNodes(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}