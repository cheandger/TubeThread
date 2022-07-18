import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ThirdReader extends Thread {

    private final LinkedList<Integer> ourDeque;
    private final Integer SIZE;

    public ThirdReader(LinkedList<Integer> ourDeque, Integer size) {
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

        if (ourDeque.size()==SIZE){
            notify();
            Integer i = ourDeque.poll();
            System.out.println(this.getId() + " Reading by 3stReaderThread: " + i);
        }notifyAll();
    }

}










/*

public class Program {

    public static void main(String[] args) {

        Store store=new Store();
        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
// Класс Магазин, хранящий произведенные товары
class Store{
    private int product=0;


    public synchronized void get() {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
    public synchronized void put() {
        while (product>=3) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
// класс Производитель
class Producer implements Runnable{

    Store store;
    Producer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.put();
        }
    }
}
// Класс Потребитель
class Consumer implements Runnable{

    Store store;
    Consumer(Store store){
        this.store=store;
    }
    public void run(){
        for (int i = 1; i < 6; i++) {
            store.get();
        }
    }
}
   */



















