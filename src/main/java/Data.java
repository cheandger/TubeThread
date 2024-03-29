import java.util.LinkedList;

import java.util.Random;


public class Data {
    private final LinkedList<Integer> ourDeque;
    private final Integer SIZE;


    public Data(LinkedList<Integer> ourDeque, Integer size) {
        this.ourDeque = ourDeque;
        this.SIZE = size;

    }

    public synchronized void pollTheInt() throws InterruptedException {
        wait();


while (!ourDeque.isEmpty()) {
    boolean random = new Random().nextBoolean();//Чтобы потоки не пытались вычитать то,чего нет, и не использовать Concurrent коллекции, будем
    Integer i;                                //рандомно брать элементы из начала и из конца(в принципе можно заморочится на разбивание списка, на подсписки, но в условии этого не было)
    if (random){i=ourDeque.pollLast();
    }else {i=ourDeque.pollFirst();}
       System.out.println(i  +" will be read and erase by some of ReaderThreads.  ... Oooops it has already done. It was the Reader"+ Thread.currentThread().getName() +"");
    //Лучше выводить результат внутри метода - внутри потока задержка слишком большая и за счет несихроннизированного вывода в консоль его информативность ->0
    //есть мнение, что для синх вывода в консоль надо посмотреть, как в java работают тайминги, и попробовать привязаться к ним, если понадобится в будущем.
}
       wait();


       //возвращаем инты в методах, чтобы работала контакенация в выводе результатов потока писателя, так получается более информативно,
        //хотя можно и здесь sout выполнить, читается хуже. В принципе оба метода можно сделать void
    }

    public synchronized Integer writeInt() throws InterruptedException {
        Integer someInt = new java.util.Random().nextInt(500);
        ourDeque.add(someInt);
        if (ourDeque.size()>=SIZE)notifyAll();// Как только очередь набила нужную емкость
        // говорим потокам читателям начинать свою работу. При этом Writer в wait не уходит, максимум постоит в очереди на монитор.
        // Сначала проверим равенство с вместимостью листа, и если вместимость равна или, не дай бог превышена,
        //(мало-ли что, многопоточность она такая), то командуем потокам читателям-ассенизаторам выйти уже из комнатки ожидания и начинать разгребать)

        return someInt;
    }



}
