class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Boolean> incoming = new HashMap<>();
        for (List<String> path: paths) {
            incoming.put(path.get(1), false);
        }
        for (List<String> path: paths) {
            if (incoming.containsKey(path.get(0))) {
                incoming.put(path.get(0), true);
            }
        }
        for (String key: incoming.keySet()) {
            if (!incoming.get(key)) {
                return key;
            }
        }
        return "";
    }
}