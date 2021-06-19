/**
 * Runtime: 4 ms, faster than 50.15% of Java online submissions for Smallest Subsequence of Distinct Characters.
 * Memory Usage: 39.2 MB, less than 37.90% of Java online submissions for Smallest Subsequence of Distinct Characters.
 * Time Complexity: O(n)
 * Space Complexity: O(1) - As the space can be maximum of 26 (characters)
 */
class Solution {
    public String smallestSubsequence(String s) {
        HashSet existsInSolution = new HashSet<>();
        Map<Character, Integer> lastOccurrence = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length();  i++) {
            lastOccurrence.put(s.charAt(i), i);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while (!existsInSolution.contains(ch)) {
                while (!stack.isEmpty() && ch < stack.peek() && lastOccurrence.get(stack.peek()) > i) {
                    existsInSolution.remove(stack.pop());
                }
                existsInSolution.add(ch);
                stack.push(ch);
            }
        }

        StringBuilder result = new StringBuilder(stack.size());
        for (Character ch : stack) {
            result.append(ch.charValue());
        }
        return result.toString();
    }
}