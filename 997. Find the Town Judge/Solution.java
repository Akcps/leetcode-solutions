/**
 * Runtime: 3 ms, faster than 94.88% of Java online submissions for Find the Town Judge.
 * Memory Usage: 58.4 MB, less than 96.67% of Java online submissions for Find the Town Judge.
 */
class Solution {
    public int findJudge(int N, int[][] trust) {
        boolean[] judgeFlag = new boolean[N+1];
        Arrays.fill(judgeFlag, true);
        for (int i = 0; i < trust.length; i++) {
            int j = trust[i][0];
            judgeFlag[j] = false;
        }

        int count = 0;
        int judge = -1;
        for (int i = 1; i <= N; i++) {
           if (judgeFlag[i]) {
               count++;
               judge = i;
           }
        }

        if (count > 1)
            return -1;

        int trustCount = 0;
        for (int i = 0; i < trust.length; i++) {
            int j = trust[i][0];
            int k = trust[i][1];
            if (k == judge) {
               trustCount++;
            }
            if (j == judge) {
                return -1;
            }
        }

        if (trustCount == N-1)
            return judge;
        else
            return -1;

    }
}