class MinAbsoluteDifference {

    public int minAbsoluteDiff (int[] A, int[] B) {
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        while (i < A.length && j < B.length && minDiff != 0) {
            minDiff = Math.min(minDiff, Math.abs(A[i] - B[j]));
            if (A[i] <= B[j]) {
                i++;
            } else {
                j++;
            }
        }
        return minDiff;
    }
}