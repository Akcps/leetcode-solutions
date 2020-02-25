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
 * Runtime: 22 ms, faster than 30.27% of Java online submissions for Serialize and Deserialize Binary Tree.
 * Memory Usage: 43.6 MB, less than 15.24% of Java online submissions for Serialize and Deserialize Binary Tree.
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) {
            return "[null]";
        }

        ArrayList<String> list = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {

            int s = q.size();

            for(int i = 0; i < s; i++) {
                TreeNode temp = q.poll();

                if(temp == null) {
                    list.add("null");
                    continue;
                }

                list.add("" + temp.val);

                q.add(temp.left);
                q.add(temp.right);

            }
        }

        return "" + list;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.equals("[null]")) {
            return null;
        }


        data = data.substring(1, data.length() - 1);

        String[] arr = data.split(",");

        int i = 0;

        TreeNode root = new TreeNode(Integer.parseInt(arr[i++].trim()));

        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            int s = q.size();

            for(int j = 0; j < s; j++) {

                TreeNode temp = q.poll();

                String s2 = arr[i++].trim();
                String s3 = arr[i++].trim();

                if(!s2.equals("null")) {
                    temp.left = new TreeNode(Integer.parseInt(s2));
                    q.add(temp.left);
                }


                if(!s3.equals("null")) {
                    temp.right = new TreeNode(Integer.parseInt(s3));
                    q.add(temp.right);
                }
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));