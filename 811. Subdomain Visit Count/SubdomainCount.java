/**
 * Runtime: 14 ms, faster than 77.94% of Java online submissions for Subdomain Visit Count.
 * Memory Usage: 42.1 MB, less than 6.06% of Java online submissions for Subdomain Visit Count.
 * Next challenges:
 */
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public List<String> subdomainVisits(String[] cpdomains) {
        for (String cpdomain: cpdomains) {
            add(cpdomain);
        }
        List<String> result = new ArrayList<>();
        for(String key: map.keySet()) {
            result.add ("" + map.get(key) + " " + key);
        }
        return result;
    }

    private void add (String cpdomain) {
        String[] strs = cpdomain.split(" ");
        int count = Integer.valueOf(strs[0]);
        String s = strs[1];
        map.put(s, map.getOrDefault(s, 0) + count);
        for (int i = 1; i < strs[1].length(); i++) {
            char c = strs[1].charAt(i);
            if (c == '.') {
                s = strs[1].substring(i + 1, strs[1].length());
                map.put(s, map.getOrDefault(s, 0) + count);
            }
        }
    }
}