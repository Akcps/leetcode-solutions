/**
 * A lock which lets multiple readers read at the same time, but only one writer write at a time.
 */
class ReaderWriterLock {
    int readers;
    boolean isWriteLocked;

    public ReaderWriterLock() {
        this.readers = 0;
        this.isWriteLocked = false;
    }

    public synchronized void acquireReadLock() throws InterruptedException {
        while (isWriteLocked) {
            wait();
        }
        readers++;
    }

    public synchronized void releaseReadLock() {
        readers--;
        notify();
    }

    public synchronized void acquireWriteLock() throws InterruptedException {
        while (isWriteLocked || readers != 0) {
            wait();
        }
        isWriteLocked = true;
    }

    public synchronized void releaseWriteLock() {
        isWriteLocked = false;
        notify();
    }
}