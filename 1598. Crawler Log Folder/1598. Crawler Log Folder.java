/**
 * Runtime: 1 ms, faster than 78.74% of Java online submissions for Crawler Log Folder.
 * Memory Usage: 38.3 MB, less than 89.70% of Java online submissions for Crawler Log Folder.
 */

class Solution {
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for(String log: logs) {
            if (log.equals("../")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            if (!log.startsWith(".")) {
                stack.push(log);
            }

        }
        return stack.size();
    }
}