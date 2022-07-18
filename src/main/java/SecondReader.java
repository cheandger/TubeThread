import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class SecondReader extends Thread {
    private final LinkedList<Integer> ourDeque;
    private final Integer SIZE;

    public SecondReader(LinkedList<Integer> ourDeque, Integer size) {
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

        wait();

        Integer i = ourDeque.poll();
        System.out.println(this.getId() + " Reading by 1stReaderThread: " + i);
        notifyAll();
        while (ourDeque.isEmpty())
            wait();
    }


    }








    /*    while (!ourDeque.isEmpty()){
            if (ourDeque.size()<=SIZE){
                wait();
            }else {notifyAll();
                Integer i = ourDeque.poll();
                System.out.println(this.getId() + " Reading by 1stReaderThread: " + i);}
        }
        notifyAll();
    }
}
*/