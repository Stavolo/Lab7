public class Main {

    public static void main(String[] args) {
        long iterations = 1000000;
        int threads = 20;
        MonteCarloSimulation pi = new MonteCarloSimulation(threads, iterations);
        double piValue = 0;
        try {
            piValue = pi.CalculatePi();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Пораховане PI: " + piValue);
        System.out.println("Точки в кругу: " + pi.GetPointInCircleNumber());
        System.out.println("Всі точки: " + pi.GetPointInSquareNumber());
        System.out.println("Час для розрахунку: " + pi.GetCalculationTime());
    }
}
