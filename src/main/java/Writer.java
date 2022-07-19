

public class Writer extends Thread {

  private final Data data;

    public Writer(Data data) {

       this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            try {

                System.out.println(Thread.currentThread().getName() + " WriterThread put the " + data.writeInt()+ " Integer in the List");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
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
