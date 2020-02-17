/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

/**
 * Runtime: 16 ms, faster than 15.32% of Java online submissions for First Bad Version.
 * Memory Usage: 36.1 MB, less than 5.63% of Java online submissions for First Bad Version.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            boolean flag = isBadVersion(mid);
            if (!flag) {
                low = mid + 1;
            } else {
                if (mid - 1 >= 0) {
                    boolean prev = isBadVersion(mid - 1);
                    if (!prev) {
                        return mid;
                    }
                }
                high = mid - 1;
            }
        }
        return low;
    }


}

/**
 * Runtime: 12 ms, faster than 56.50% of Java online submissions for First Bad Version.
 * Memory Usage: 36.4 MB, less than 5.63% of Java online submissions for First Bad Version.
 */
public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


}