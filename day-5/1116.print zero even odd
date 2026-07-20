import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    private int state = 0; // 0: zero, 1: odd, 2: even
    
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            while (state != 0) {
                wait();
            }
            printNumber.accept(0);
            if (i % 2 == 1) {
                state = 1; // Next should be odd
            } else {
                state = 2; // Next should be even
            }
            notifyAll();
        }
    }

    public synchronized void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            while (state != 2) {
                wait();
            }
            printNumber.accept(i);
            state = 0; // Next should be zero
            notifyAll();
        }
    }

    public synchronized void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            while (state != 1) {
                wait();
            }
            printNumber.accept(i);
            state = 0; // Next should be zero
            notifyAll();
        }
    }
}
