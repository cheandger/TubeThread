
public class SecondReader extends Thread {
    private final Data data;

    public SecondReader(Data data) {
      this.data=data;
    }

    @Override
    public void run() {

        while (true) {
            try {

               data.pollTheInt();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
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