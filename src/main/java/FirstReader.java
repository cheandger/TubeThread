import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

public class FirstReader extends Thread {
    private final LinkedList<Integer> ourDeque;
    private final Integer SIZE;

    public FirstReader(LinkedList<Integer> ourDeque, Integer size) {

        this.ourDeque = ourDeque;
        this.SIZE = size;
    }

    @Override
    public void run() {

        while (true) {
            try {
                pollTheInt();

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    public synchronized void pollTheInt() throws InterruptedException {

if (ourDeque.size()<SIZE)
{wait();}else {notify();}
        Integer i = ourDeque.poll();
        System.out.println(this.getId() + " Reading by 1stReaderThread: " + i);
        notifyAll();
        while (ourDeque.isEmpty())wait();


    }

}

