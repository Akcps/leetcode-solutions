/**
 * Blocking Queue for producer consumer using Reenterant lock
 * @param <E>
 */
public class BlockingQueue<E> {
    private int max;
    private Queue<E> queue;
    private ReentrantLock lock;
    private Condition notFull;
    private Condition notEmpty;

    public BlockingQueue(int size) {
        this.max = size;
        this.queue = new LinkedList<>();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    public void put(E e) {
        lock.lock();
        try {
            if (queue.size() == max) {
                notFull.wait();
            }
            queue.add(e);
            notEmpty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public E take() {
        lock.lock();
        try {
            while (queue.size() == 0) {
                notEmpty.wait();
            }
            E item = queue.remove();
            notFull.signalAll();
            return item;
        } finally {
            lock.unlock();
        }
    }
}

/**
 * Blocking Queue for producer consumer using wait - notifyAll
 * @param <E>
 */
public class BlockingQueue<E> {
    private int max;
    private Queue<E> queue;
    private Object lock;

    public BlockingQueue(int size) {
        this.max = size;
        this.queue = new LinkedList<>();
        this.lock = new Object();
    }

    public void put(E e) throws InterruptedException {
        synchronized (lock) {
            if (queue.size() == max) {
                lock.wait();
            }
            queue.add(e);
            lock.notifyAll();
        }
    }

    public E take() throws InterruptedException {
        synchronized (lock) {
            while (queue.size() == 0) {
                lock.wait();
            }
            E item = queue.remove();
            lock.notifyAll();
        }
        return item;
    }
}