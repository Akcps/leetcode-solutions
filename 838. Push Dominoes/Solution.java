/**
 * Runtime: 10 ms, faster than 67.63% of Java online submissions for Push Dominoes.
 * Memory Usage: 42.8 MB, less than 50.00% of Java online submissions for Push Dominoes.
 */
class Solution {
    public String pushDominoes(String dominoes) {
        char[] A = dominoes.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') {
                force = N;
            } else if (A[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N - 1; i >= 0; --i) {
            if (A[i] == 'L') {
                force = N;
            } else if (A[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f: forces) {
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        }
        return ans.toString();
    }
}