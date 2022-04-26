import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {



        ThreadsPrint threadsPrint = new ThreadsPrint();



        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadsPrint.printA();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                threadsPrint.printB();
            }
        }).start();

//        new Thread(() -> {
//            for (int i = 0; i < 5; i++) {
//                threadsPrint.printC();
//            }
//        }).start();

    }
}
