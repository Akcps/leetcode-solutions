/**
 * Runtime: 4 ms, faster than 100.00% of Java online submissions for Fizz Buzz Multithreaded.
 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Fizz Buzz Multithreaded.
 */
class FizzBuzz {
    private int n;
    private int counter;
    private boolean normal;
    private boolean divisibleBy3;
    private boolean divisibleBy5;
    private boolean divisibleBy35;

    public FizzBuzz(int n) {
        this.n = n;
        this.counter = 1;
        this.normal = true;
        this.divisibleBy3 = false;
        this.divisibleBy5 = false;
        this.divisibleBy35 = false;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (this.counter <= this.n) {
            synchronized(this) {
                while (!this.divisibleBy3) {
                    wait();
                }
                if (this.counter > this.n)
                    return;
                printFizz.run();
                check();
                this.notifyAll();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (this.counter <= this.n) {
            synchronized(this) {
                while (!this.divisibleBy5){
                    wait();
                }
                if (this.counter > this.n)
                    return;

                printBuzz.run();
                check();
                this.notifyAll();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (this.counter <= this.n) {
            synchronized(this) {
                while (!this.divisibleBy35){
                    wait();
                }
                if (this.counter > this.n)
                    return;
                printFizzBuzz.run();
                check();
                this.notifyAll();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (this.counter <= this.n) {
            synchronized(this) {
                while (!this.normal) {
                    wait();
                }
                if (this.counter > this.n)
                    return;
                printNumber.accept(this.counter);
                check();
                this.notifyAll();
            }
        }
    }

    private synchronized void check() {
        this.counter++;
        if (this.counter % 3 == 0 && this.counter % 5 == 0) {
            this.divisibleBy3 = false;
            this.divisibleBy5 = false;
            this.divisibleBy35 = true;
            this.normal = false;
        } else if (this.counter % 3 == 0) {
            this.divisibleBy3 = true;
            this.divisibleBy5 = false;
            this.divisibleBy35 = false;
            this.normal = false;

        } else if (this.counter % 5 == 0) {
            this.divisibleBy3 = false;
            this.divisibleBy5 = true;
            this.divisibleBy35 = false;
            this.normal = false;
        } else {
            this.divisibleBy3 = false;
            this.divisibleBy5 = false;
            this.divisibleBy35 = false;
            this.normal = true;
        }
        if (this.counter > this. n) {
            this.divisibleBy3 = true;
            this.divisibleBy5 = true;
            this.divisibleBy35 = true;
            this.normal = true;
        }
    }
}