/**
 * Runtime: 5 ms, faster than 73.54% of Java online submissions for Simplify Path.
 * Memory Usage: 39.2 MB, less than 20.00% of Java online submissions for Simplify Path.
 */
class Solution {
    public String simplifyPath(String path) {
        if (path.isEmpty()) {
            return path;
        }
        Stack<String> stack = new Stack<String>();
        String[] strs = path.split("/");

        for (String dir: strs) {

            if (dir.equals(".") || dir.isEmpty()) {

            } else if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}