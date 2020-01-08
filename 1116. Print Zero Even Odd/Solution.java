/**
 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Print Zero Even Odd.
 * Memory Usage: 35.4 MB, less than 100.00% of Java online submissions for Print Zero Even Odd.
 */
class ZeroEvenOdd {
    private int n;
    private int counter;
    private boolean zero;
    private boolean odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.counter = 1;
        this.zero = true;
        this.odd = true;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (this.counter <= n) {
            synchronized(this) {
                while(!zero) {
                    wait();
                }
                if (this.counter <= n)
                    printNumber.accept(0);
                this.zero = false;
                this.notifyAll();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (this.counter <= n) {
            synchronized(this) {
                while(zero || odd) {
                    wait();
                }
                if (this.counter <= n)
                    printNumber.accept(counter);
                this.counter++;
                this.odd = true;
                this.zero = true;
                this.notifyAll();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (this.counter <= n) {
            synchronized(this) {
                while(zero || !odd) {
                    wait();
                }
                if (this.counter <= n)
                    printNumber.accept(counter);
                this.counter++;
                this.odd = false;
                this.zero = true;
                this.notifyAll();
            }
        }
    }
}