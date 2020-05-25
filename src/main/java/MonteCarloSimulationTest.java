import static org.junit.Assert.*;

public class MonteCarloSimulationTest {

    @org.junit.Test
    public void calculatePi() throws InterruptedException {
        double expectedValue = 3.1415;
        int threads = 8;
        long iterations = 1000000;
        MonteCarloSimulation pi = new MonteCarloSimulation(threads, iterations);
        double actualValue = pi.CalculatePi();
        assertEquals(expectedValue, actualValue, 0.001);
    }
}