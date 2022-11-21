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
        int preIndex = 0;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
    
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int index = 0;
            for (Integer val : inorder) {
                indexMap.put(val, index++);
            }
            return constructTree(preorder, inorder, 0, inorder.length);
        }

        private TreeNode constructTree(int[] preorder, int[] inorder, int low, int high) {
            if (low >= high) {
                return null;
            } 
            
            int searchVal = preorder[preIndex++];
            TreeNode node = new TreeNode(searchVal);
            int partitionIndex = indexMap.get(searchVal);
            node.left = constructTree(preorder, inorder, low, partitionIndex);
            node.right = constructTree(preorder, inorder, partitionIndex + 1, high);
            return node;
        }
    
}