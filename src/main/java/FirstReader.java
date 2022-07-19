

public class FirstReader extends Thread {
  private final Data data;

    public FirstReader(Data data) {

        this.data = data;
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

