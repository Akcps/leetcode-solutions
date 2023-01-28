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
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.val);
        }
        
        // left boundary
        TreeNode t = root.left;
        while (t != null) {
            if (!isLeaf(t)) {
                result.add(t.val);
            }
            if (t.left != null) {
                t = t.left;
            } else {
                t = t.right;
            }

        }
        
        // leaves
        addLeaves(result, root);
        
        // right boundary
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
        while (!s.empty()) {
            result.add(s.pop());
        }
        return result;
    }

    
    private boolean isLeaf(TreeNode t) {
        return t.left == null && t.right == null;
    }
    
    private void addLeaves(List<Integer> result, TreeNode root) {
        if (isLeaf(root)) {
            result.add(root.val);
        } else {
            if (root.left != null) {
                addLeaves(result, root.left);
            }
            if (root.right != null) {
                addLeaves(result, root.right);
            }
        }
    }
    

}