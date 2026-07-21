import java.util.concurrent.Semaphore;

class FooBar {
    private int n;
    private Semaphore fooSemaphore;
    private Semaphore barSemaphore;

    public FooBar(int n) {
        this.n = n;
        this.fooSemaphore = new Semaphore(1); // foo starts immediately
        this.barSemaphore = new Semaphore(0); // bar waits
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooSemaphore.acquire(); // Wait for foo's turn (decrements permit to 0)
            printFoo.run();
            barSemaphore.release(); // Give bar its turn (increments permit to 1)
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barSemaphore.acquire();
            printBar.run();
            fooSemaphore.release(); 
        }
    }
}
