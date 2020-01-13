/**
 * Runtime: 72 ms, faster than 92.36% of Java online submissions for Design File System.
 * Memory Usage: 71 MB, less than 100.00% of Java online submissions for Design File System.
 */
class FileSystem {

    Map<String, Integer> pathMap;
    Set<String> parentDirSet;

    public FileSystem() {
        pathMap = new HashMap<>();
        parentDirSet = new HashSet<>();
    }

    public boolean createPath(String path, int value) {
        int lastIndex = path.lastIndexOf("/");
        String parentDir = path.substring(0, lastIndex);
        if (pathMap.containsKey(path)) {
            return false;
        } else if (!parentDir.equals("") && !parentDirSet.contains(parentDir)) {
            return false;
        } else {
            parentDirSet.add(path);
            pathMap.put(path, value);
            return true;
        }
    }

    public int get(String path) {
        return pathMap.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */