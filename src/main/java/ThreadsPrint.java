public class ThreadsPrint {

    private int flag = 1;

    public synchronized void printA(){
//        System.out.println("Method A flag: " + flag);
        if(flag == 1){
            try {
                System.out.println("A");
                flag = 2;
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void printB(){
//        System.out.println("Method B flag: " + flag);
        if(flag == 2){
            try {
                System.out.println("B");
                flag = 1;
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void printC(){
//        System.out.println("Method C flag: " + flag);
        if (flag == 3){
            try {
                System.out.println("C");
                flag = 1;
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
