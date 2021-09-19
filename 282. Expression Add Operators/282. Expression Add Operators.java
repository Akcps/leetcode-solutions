/**
 * Runtime: 90 ms, faster than 53.44% of Java online submissions for Expression Add Operators.
 * Memory Usage: 40 MB, less than 50.44% of Java online submissions for Expression Add Operators.
 */

class Solution {
    List<String> results = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        makeTarget(num, 0, target, "", 0, 0);
        return results;
    }

    private void makeTarget(String num, int index, int target, String str, long resSoFar, long prev) {
        if (num.length() == index) {
            if (resSoFar == target) {
                results.add(str);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {
            if (i > index && num.charAt(index) == '0') {
                break;
            }
            long val = Long.valueOf(num.substring(index, i + 1));
            if (index == 0) {
                makeTarget(num, i + 1, target, str + val, val, val);
            } else {
                makeTarget(num, i + 1, target, str + "+" + val, resSoFar + val, val);
                makeTarget(num, i + 1, target, str + "-" + val, resSoFar - val, -val);
                makeTarget(num, i + 1, target, str + "*" + val, resSoFar - prev + prev * val, prev * val);
            }

        }
    }

}