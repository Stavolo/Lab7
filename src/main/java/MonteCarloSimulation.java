import java.util.ArrayList;
import java.util.List;

public class MonteCarloSimulation {
    private long pointInCircle = 0;
    private long pointInSquare = 0;
    private int threads = 0;

    public MonteCarloSimulation(int threadsNumber, long pointInSquareNumber) {
        this.threads = threadsNumber;
        pointInSquare = pointInSquareNumber;
    }

    private List<Executor> executors = new ArrayList<>();
    private List<Thread> threadsAL = new ArrayList<>();

    private long calculationTime = 0;
    public final double GetCalculationTime() {
        return calculationTime / Math.pow(10, 9);
    }
    public final long GetPointInSquareNumber() {
        return pointInSquare;
    }
    public final long GetPointInCircleNumber() {
        return pointInCircle;
    }

    public double CalculatePi() throws InterruptedException {
        long startTime = System.nanoTime();
        for (int i = 0; i < threads; i++) {
            Executor executor = new Executor(pointInSquare / threads);
            Thread thread = new Thread(executor);
            thread.start();
            executors.add(executor);
            threadsAL.add(thread);
        }

        for (Thread thread : threadsAL) {
            if (thread.isAlive())
                thread.join();
        }
        pointInSquare = 0;
        for (Executor executor : executors) {
            pointInCircle += executor.GetPointInCircle();
            pointInSquare += executor.GetPointInSquare();
        }
        calculationTime = System.nanoTime() - startTime;
        return (pointInCircle * 1.0 / pointInSquare) * 4;
    }

}