/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Monotonic Array.
 * Memory Usage: 65.7 MB, less than 21.43% of Java online submissions for Monotonic Array.
 */
class Solution {
    public boolean isMonotonic(int[] A) {
        if (A == null || A.length == 0)
            return false;
        else if (A.length == 2 || A.length == 1)
            return true;
        else
            return checkMonotonicArray(A);
    }

    private boolean checkMonotonicArray(int[] A) {
        boolean increasing = false;
        boolean equal = false;
        boolean flag = true;
        if (A[0] < A[1])
            increasing = true;
        else if (A[0] == A[1])
            equal = true;

        int i = 1;
        while(i < A.length - 1) {
            if (equal) {
                if (A[i] > A[i+1]) {
                    increasing = false;
                    equal = false;
                }
                else if (A[i] < A[i+1]) {
                    increasing = true;
                    equal = false;
                }

            } else if (increasing) {
                if (A[i] > A[i+1]){
                    flag = false;
                    break;
                }
            } else {
                if (A[i] < A[i+1]){
                    flag = false;
                    break;
                }
            }
            i++;
        }
        return flag;
    }
}
