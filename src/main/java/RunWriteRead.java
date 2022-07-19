import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;

public class RunWriteRead {
    public static void main(String[] args) {
//Суть задачи в следующем: Есть коллекция, с задаваемой емкостью, есть поток, который пишет в нее инты, и несколько потоков, которые эти инты читают и удаляют,
//начинают потоки читать, когда коллекция заполнится. Когда коллекция опустеет, потоки-читатели приостанавливают работу, пока она снова не наполнится.
// Каждый поток делает свою работу в бесконечном цикле.

        LinkedList<Integer> firstPanCake = new LinkedList<>();

     Data data = new Data(firstPanCake,15);
        Thread writeThread = new Writer(data);
        Thread firstReadThread = new FirstReader(data);
        Thread secondReadThread = new SecondReader(data);
        Thread thirdReadThread = new ThirdReader(data);


      /*  writeThread.setPriority(8);
        secondReadThread.setPriority(9);
        firstReadThread.setPriority(9);*/

        writeThread.start();
       secondReadThread.start();
        firstReadThread.start();
       thirdReadThread.start();

    }

}










/*System.out.println(a);
        System.out.println(b);
        System.out.println(c);*/