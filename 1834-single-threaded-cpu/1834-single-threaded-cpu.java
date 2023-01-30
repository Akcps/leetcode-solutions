class Solution {
    public int[] getOrder(int[][] tasks) {
        int res[] = new int[tasks.length];
        
        List<Task> taskList = new ArrayList<>();
        
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(tasks[i][0], tasks[i][1], i));
        }
        taskList.sort((a,b) -> (a.start - b.start));
        System.out.println(taskList);
        
        PriorityQueue<Task> heap = new PriorityQueue<>((a,b) -> (a.processingTime != b.processingTime ? a.processingTime - b.processingTime: a.index - b.index));
        
        int taskProcessedCount = 0;
        int time = 0;
        int taskIdx = 0;
        while(taskProcessedCount < tasks.length) {
            if (heap.isEmpty() && time < taskList.get(taskIdx).start) {
                time = taskList.get(taskIdx).start;
            }
            
            while (taskIdx < tasks.length && time >= taskList.get(taskIdx).start){
                heap.add(taskList.get(taskIdx));
                taskIdx++;
            }
            
            Task t = heap.poll();
            
         
            time += t.processingTime; 
            res[taskProcessedCount++] = t.index;
        }
        
        return res;
    }
    
    class Task {
        int start;
        int processingTime;
        int index;
        
        public Task(int start, int processingTime, int index) {
            this.start = start;
            this.processingTime = processingTime;
            this.index = index;
        }
        
        public String toString() {
            return " " + this.start + ":" + this.processingTime + ", ind: " + this.index;
        }
    }
}