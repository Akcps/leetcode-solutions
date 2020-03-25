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
 * Runtime: 1 ms, faster than 95.43% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
 * Memory Usage: 39.8 MB, less than 21.82% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
 */
class Solution {
    Map<Integer, Integer> indexMap;
    int postOrderIndex;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = buildIndexMap(inorder);
        postOrderIndex = postorder.length - 1;
        return build(0, postOrderIndex, inorder, postorder);
    }

    private TreeNode build(int low, int high, int[] inorder, int[] postorder) {
        if (low > high) {
            return null;
        }

        TreeNode node = new TreeNode(postorder[postOrderIndex]);
        int index = indexMap.get(postorder[postOrderIndex]);
        postOrderIndex--;
        node.right = build(index + 1, high, inorder, postorder);
        node.left = build(low, index - 1, inorder, postorder);
        return node;
    }

    private Map buildIndexMap(int[] inorder) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return indexMap;
    }
}