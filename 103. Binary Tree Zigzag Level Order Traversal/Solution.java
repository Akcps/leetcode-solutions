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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 * Memory Usage: 36.2 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<List<Integer>>();
        }
        List<List<Integer>> res = new LinkedList<>();
        int level=1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> curLevelList = new LinkedList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++){
                TreeNode cur = queue.poll();

                if(level % 2 == 1)
                    curLevelList.add(cur.val);
                else
                    curLevelList.add(0, cur.val);

                if(cur.left != null)
                    queue.add(cur.left);
                if(cur.right != null)
                    queue.offer(cur.right);
            }
            res.add(curLevelList);
            level++;
        }
        return res;
    }
}