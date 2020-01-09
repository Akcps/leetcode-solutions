/**
 * Runtime: 7 ms, faster than 98.78% of Java online submissions for Design Bounded Blocking Queue.
 * Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Design Bounded Blocking Queue.
 */
class BoundedBlockingQueue {
    private Queue<Integer> queue;
    private int capacity;

    public BoundedBlockingQueue(int capacity) {
        this.queue = new LinkedList<Integer>();
        this.capacity = capacity;
    }

    public void enqueue(int element) throws InterruptedException {
        synchronized (this) {
            while (size() == this.capacity) {
                wait();
            }
            queue.add(element);
            notifyAll();
        }
    }

    public int dequeue() throws InterruptedException {
        synchronized (this) {
            while (size() == 0) {
                wait();
            }
            int element = queue.poll();
            notifyAll();
            return element;
        }
    }

    public int size() {
        return this.queue.size();
    }
}