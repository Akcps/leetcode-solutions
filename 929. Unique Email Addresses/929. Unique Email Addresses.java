/**
 * Runtime: 17 ms, faster than 62.00% of Java online submissions for Unique Email Addresses.
 * Memory Usage: 39.6 MB, less than 59.86% of Java online submissions for Unique Email Addresses.
 */

class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0];
            String domain = parts[1];
            StringBuilder localName = new StringBuilder();
            for (char c : local.toCharArray()) {
                if (c == '+') {
                    break;
                }
                if (c != '.') {
                    localName.append(c);
                }
            }
            String fullEmail = localName.toString() + "@" + domain;
            uniqueEmails.add(fullEmail);
        }
        return uniqueEmails.size();
    }
}