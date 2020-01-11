/**
 * Runtime: 1 ms, faster than 90.89% of Java online submissions for Compare Version Numbers.
 * Memory Usage: 34.9 MB, less than 100.00% of Java online submissions for Compare Version Numbers.
 */
class Solution {

    public int compareVersion(String version1, String version2) {
        if (version1 == null && version2 == null)
            return 0;
        if (version1 != null && version2 == null)
            return 1;
        if (version1 == null && version2 != null)
            return -1;
        String[] v1s = version1.split("\\.");
        String[] v2s = version2.split("\\.");
        int i;
        for (i = 0; i < Math.min(v1s.length, v2s.length); i++) {
            if (Integer.valueOf(v1s[i]) > Integer.valueOf(v2s[i]))
                return 1;
            else if (Integer.valueOf(v1s[i]) < Integer.valueOf(v2s[i]))
                return -1;
        }
        if (v1s.length > v2s.length) {
            while (i < v1s.length) {
                if (Integer.valueOf(v1s[i]) > 0) {
                    return 1;
                } else
                    i++;
            }
            return 0;
        }
        else if (v1s.length < v2s.length) {
            while (i < v2s.length) {
                if (Integer.valueOf(v2s[i]) > 0) {
                    return -1;
                } else
                    i++;
            }
            return 0;
        }
        else
            return 0;
    }
}