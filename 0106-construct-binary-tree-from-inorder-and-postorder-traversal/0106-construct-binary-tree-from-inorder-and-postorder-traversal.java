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
    int postIndex = 0;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = inorder.length - 1;
        TreeNode root = constructTree(inorder, postorder, constructInorderMap(inorder), 0, inorder.length - 1);
        return root;
        
    }
    
    private Map<Integer, Integer> constructInorderMap(int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return inorderMap;
    }
    
    private TreeNode constructTree(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap, int left, int right) {
        if (left < 0 || left > right || right >= postorder.length) {
            return null;
        }
        int val = postorder[postIndex--];
        TreeNode newNode = new TreeNode(val);
        newNode.right = constructTree(inorder, postorder,inorderMap, inorderMap.get(val) + 1, right);
        newNode.left = constructTree(inorder, postorder,inorderMap, left, inorderMap.get(val) - 1);
        return newNode;
    }

    
}