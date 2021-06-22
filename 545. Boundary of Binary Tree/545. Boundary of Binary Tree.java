/**
 * Runtime: 2 ms, faster than 32.60% of Java online submissions for Boundary of Binary Tree.
 * Memory Usage: 39.3 MB, less than 71.66% of Java online submissions for Boundary of Binary Tree.
 */

/**
 * Approach
 * 1. Add the root.
 * 2. Add the left boundary
 * 3. Add the leaves
 * 4. Add the right boundary, use stack to reverse the order.
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
    public boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }

    public void addLeaves(List<Integer> res, TreeNode root) {
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(res, root.left);
            }
            if (root.right != null) {
                addLeaves(res, root.right);
            }
        }
    }

    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // Add the root
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        // Add the left boundary
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                res.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        // Add the leaves
        addLeaves(res, root);

        //Add the right boundary
        Stack<Integer> s = new Stack<>();
        t = root.right;
        while (t != null) {
            if (!isLeaf(t)) {
                s.push(t.val);
            }
            if (t.right != null) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        // pop the right boundary in reverse order
        while (!s.empty()) {
            res.add(s.pop());
        }
        return res;
    }
}