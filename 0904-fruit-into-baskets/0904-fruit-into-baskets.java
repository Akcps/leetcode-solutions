class Solution {
    public int totalFruit(int[] fruits) {
        
        if (fruits.length == 0) {
            return 0;
        }
        
        int start = 0;
        int end = 1;
        
        int maxTrees = 1;
        
        Map<Integer, Integer> treesSelected = new HashMap<>();
        treesSelected.put(fruits[0], 0); // keep track of the tree number and its highest index
        
        while (end < fruits.length) {
            boolean found = false;
            
            for (int key: treesSelected.keySet()) {
                if (fruits[end] == key) {
                    found = true;
                    break;
                }
            }
            
            if (!found) {
               if (treesSelected.size() == 2) {
                   int max = Integer.MIN_VALUE;
                   int min = Integer.MAX_VALUE;
                   int maxKey = 0;
                   int minKey = 0;
                    for (int key: treesSelected.keySet()) {
                        if (treesSelected.get(key) > max) {
                            max = treesSelected.get(key);
                            maxKey = key;
                        }
                        if (treesSelected.get(key) < min) {
                            min = treesSelected.get(key);
                            minKey = key;
                        }
                    }
                   maxTrees = Math.max(maxTrees, end - start); // calculate max length 
                   treesSelected.remove(minKey);
                   start = min + 1; // start from min + 1
               } 
            }
            treesSelected.put(fruits[end], end);
            end++;
        }
        maxTrees = Math.max(maxTrees, end - start);
        
        return maxTrees;
    }
}