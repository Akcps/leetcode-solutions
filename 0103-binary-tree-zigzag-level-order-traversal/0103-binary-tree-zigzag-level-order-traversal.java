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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        boolean leftToRight = true;

        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            if (leftToRight) {
                while (!s1.isEmpty()) {
                    TreeNode current = s1.pop();
                    currentLevel.add(current.val);
                    if (current.left != null) {
                        s2.push(current.left);
                    }
                    if (current.right != null) {
                        s2.push(current.right);
                    }
                }
            } else {
                while (!s2.isEmpty()) {
                    TreeNode current = s2.pop();
                    currentLevel.add(current.val);
                    if (current.right != null) {
                        s1.push(current.right);
                    }
                    if (current.left != null) {
                        s1.push(current.left);
                    }
                }
            }
            result.add(currentLevel);
            leftToRight = !leftToRight;
        }
        return result;
    }
}