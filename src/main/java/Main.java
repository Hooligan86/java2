import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        ExecutorService pool = Executors.newFixedThreadPool(3, r -> {
            return new Thread(r);
        });

        ThreadsPrint threadsPrint = new ThreadsPrint();

        for (int i = 0; i < 5; i++) {
            pool.execute(() -> {
                threadsPrint.printA();
                threadsPrint.printB();
                threadsPrint.printC();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        pool.shutdown();


//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                threadsPrint.printA();
//            }
//        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                threadsPrint.printB();
//            }
//        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                threadsPrint.printC();
//            }
//        }).start();

    }
}
