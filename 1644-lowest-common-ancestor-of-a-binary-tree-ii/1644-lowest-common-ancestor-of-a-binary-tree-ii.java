/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean pFound, qFound;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        
        TreeNode node = lca(root, p, q);
            
        if (pFound && qFound) {
            return node;
        }
        
        return null;
    }
    
    public TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
            
        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        
        if (root == p || root == q) {
            if (root == p) {
                pFound = true;
            }
            if (root == q) {
                qFound = true;
            }
            return root;
        }
        
        if (left != null && right != null) {
             return root;
        }
        
        return left != null ? left : right;
    }
}