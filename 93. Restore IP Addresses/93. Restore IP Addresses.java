/**
 * Runtime: 3 ms, faster than 67.58% of Java online submissions for Restore IP Addresses.
 * Memory Usage: 39.5 MB, less than 35.57% of Java online submissions for Restore IP Addresses.
 */
class Solution {
    List<String> ips;

    public List<String> restoreIpAddresses(String s) {
        ips = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        buildIps(s, 0, 0, sb);
        return ips;
    }

    private void buildIps(String s, int index, int count, StringBuilder current) {
        if (index == s.length() && count == 4) {
            ips.add(new String(current));
        }

        if (count > 3) {
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String currStr = s.substring(index, i + 1);
            int value = Integer.parseInt(currStr);
            if ((currStr.length() > 1 && currStr.charAt(0) == '0') || value > 255) {
                return;
            }
            StringBuilder old = new StringBuilder(current);
            current.append(currStr);
            if (count < 3) {
                current.append(".");
            }

            buildIps(s, i + 1, count + 1, current);
            current = old;
        }
    }
}