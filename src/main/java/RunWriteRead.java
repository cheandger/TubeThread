import java.util.LinkedList;

public class RunWriteRead {
    public static void main(String[] args) throws InterruptedException {


     LinkedList<Integer> firstPanCake = new LinkedList<>();
        Thread writeThread = new Writer(firstPanCake,5);
        Thread firstReadThread = new FirstReader(firstPanCake,5);
        Thread secondReadThread = new SecondReader(firstPanCake,5);
     //   Thread thirdReadThread = new ThirdReader(firstPanCake,5);


        /*writeThread.setPriority(2);
        secondReadThread.setPriority(9);
        firstReadThread.setPriority(9);*/

        writeThread.start();
       secondReadThread.start();
        firstReadThread.start();
       //thirdReadThread.start();






    }

}










/*System.out.println(a);
        System.out.println(b);
        System.out.println(c);*/