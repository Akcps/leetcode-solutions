/**
 * Runtime: 11 ms, faster than 100.00% of Java online submissions for Building H2O.
 * Memory Usage: 37 MB, less than 100.00% of Java online submissions for Building H2O.
 */
class H2O {
    private int hydrogenCount;
    private int oxygenCount;

    public H2O() {
        this.hydrogenCount = 0;
        this.oxygenCount = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while(this.hydrogenCount == 2) {
                wait();
            }
            this.hydrogenCount++;
            this.reset();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.
            releaseHydrogen.run();
            notifyAll();
        }

    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while(this.oxygenCount == 1) {
                wait();
            }
            this.oxygenCount++;
            this.reset();
            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            notifyAll();
        }
    }

    private void reset() {
        if (this.hydrogenCount == 2 && this.oxygenCount == 1) {
            this.hydrogenCount = 0;
            this.oxygenCount = 0;
        }
    }
}