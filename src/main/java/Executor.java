public class Executor implements Runnable {
    private long pointInSquare = 0;
    private long pointInCircle = 0;

    public Executor(long iterations) {
        pointInSquare = iterations;
    }

    public final long GetPointInSquare() {
        return pointInSquare;
    }

    public final long GetPointInCircle() {
        return pointInCircle;
    }

    @Override
    public void run() {
        int currentPoint=0;
        while (currentPoint < pointInSquare) {
            double x = Math.random();
            double y = Math.random();
            double radius = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            if (radius <= 1)
                pointInCircle++;
            currentPoint++;
        }
    }
}