/**
 * Runtime: 10 ms, faster than 44.40% of Java online submissions for Print in Order.
 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Print in Order.
 */
class Foo {
    int count;
    public Foo() {
        count = 1;
    }

    public void first(Runnable printFirst) throws InterruptedException {

        synchronized (this) {
            while(count != 1) {
                wait();
            }
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            count = 2;
            this.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) {
            while(count != 2) {
                wait();
            }
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            count = 3;
            notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) {
            while(count != 3) {
                wait();
            }
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            notifyAll();
        }
    }
}