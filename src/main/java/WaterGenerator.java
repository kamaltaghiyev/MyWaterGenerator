public class WaterGenerator extends Thread{
    public static int countHydrogen = 0;
    public static int countOxygen = 0;
    public synchronized void oxygenGenerator() throws InterruptedException {
        countOxygen++;
        System.out.println("Oxygen created");
        if(countHydrogen<2){
            wait();
        }
        if(countHydrogen>=2 && countOxygen>=1) {
            System.out.println("Water genereted");
            countOxygen--;
            countHydrogen-=2;
        }
    }
    public synchronized void hydrogenGenerator(){
        countHydrogen++;
        System.out.println("Hydrogen created");
        notify();
        if(countHydrogen>=2 && countOxygen>=1) {
            System.out.println("Water genereted");
            countOxygen--;
            countHydrogen-=2;
        }

        }
}
