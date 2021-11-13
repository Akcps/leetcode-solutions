/**
 * Runtime: 33 ms, faster than 64.92% of Java online submissions for Daily Temperatures.
 * Memory Usage: 48.4 MB, less than 82.22% of Java online submissions for Daily Temperatures.
 */
class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            } else {
                while (!st.isEmpty() && T[st.peek()] < T[i]) {
                    int ind = st.pop();
                    res[ind] = i - ind;
                }
                st.push(i);
            }
        }
        return res;
    }
}