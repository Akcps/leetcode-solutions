/**
 * Runtime: 19 ms, faster than 7.79% of Java online submissions for Print FooBar Alternately.
 * Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Print FooBar Alternately.
 */
class FooBar {
    private int n;
    private boolean odd;
    public FooBar(int n) {
        this.n = n;
        this.odd = true;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while(!this.odd) {
                    wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                this.notifyAll();
                this.odd = false;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized(this) {
                while(this.odd) {
                    wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                this.notifyAll();
                this.odd = true;
            }

        }
    }
}