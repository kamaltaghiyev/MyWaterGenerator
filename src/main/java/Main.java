import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        WaterGenerator waterGenerator = new WaterGenerator();
        Thread t1 = new Thread(() -> {
            IntStream.range(1, 100).forEach(i -> {
                try {
                    waterGenerator.oxygenGenerator();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        });
        Thread t2 = new Thread(() -> {
            IntStream.range(1, 100).forEach(i -> {
                waterGenerator.hydrogenGenerator();
            });


        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}