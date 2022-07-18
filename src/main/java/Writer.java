import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Writer extends Thread {

    private final  LinkedList<Integer> ourDeque;
    private final Integer SIZE;

    public Writer(LinkedList<Integer> ourDeque, Integer size) {

        this.ourDeque = ourDeque;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {
            try {
                writeInt();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void writeInt() throws InterruptedException {



        Integer  someInt = new java.util.Random().nextInt(500);
        ourDeque.add(someInt);
        System.out.println(this.getId() + "WriterThread:" + someInt);


        }
    }
























   /* private Integer write() throws InterruptedException {
        synchronized (ourDeque) {
            Integer someInt = new java.util.Random().nextInt(500);
            if (ourDeque.size() == SIZE) {
                ourDeque.notifyAll();
            } else {
                ourDeque.add(someInt);
            }
        }
            return someInt;
        }
    }
}
*/













/*
        while (true){
            try { synchronized (ourDeque) {
                Integer someInt = new java.util.Random().nextInt(500);
                if(ourDeque.size()==SIZE) {
                    ourDeque.notifyAll();}
                else {
                    ourDeque.add(someInt);}


                System.out.println(this.getId() + "WriterThread:" + someInt);}

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }*/
