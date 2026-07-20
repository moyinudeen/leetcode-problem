import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    
    // Array of 5 semaphores representing each individual fork
    private final Semaphore[] forks;
    // Semaphore to limit the number of philosophers eating concurrently to 4
    private final Semaphore bouncer;

    public DiningPhilosophers() {
        forks = new Semaphore[5];
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
        bouncer = new Semaphore(4);
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 1) % 5;

        // Step 1: Limit total concurrent dining attempts to 4 to prevent deadlock
        bouncer.acquire();

        // Step 2: Acquire both forks safely
        forks[leftFork].acquire();
        forks[rightFork].acquire();

        // Step 3: Execute actions
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();

        // Step 4: Release both forks
        forks[leftFork].release();
        forks[rightFork].release();

        // Step 5: Leave the table
        bouncer.release();
    }
}
