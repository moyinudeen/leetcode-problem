import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    private final Semaphore[] forks;
    private final Semaphore bouncer;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        bouncer = new Semaphore(4);
    }
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;
        bouncer.acquire();
        forks[leftFork].acquire();
        forks[rightFork].acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        forks[leftFork].release();
        forks[rightFork].release();
        bouncer.release();
    }
}
