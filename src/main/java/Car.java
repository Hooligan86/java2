import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(MainClass.CARS_COUNT);

//    private static Semaphore semaphore = new Semaphore(2);

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;

    private static boolean flag = false;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MainClass.cdl.countDown();
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
            if(race.getStages().get(i) instanceof Tunnel) {
                try {
                    MainClass.semaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if(i + 1 < race.getStages().size() && !(race.getStages().get(i + 1) instanceof Tunnel) ) {
                MainClass.semaphore.release();
            }
            if(i == race.getStages().size() - 1 && !flag){
                System.out.println(this.name + " WIN!!!");
                flag = true;
            }
        }
        MainClass.cdl2.countDown();

    }
}
