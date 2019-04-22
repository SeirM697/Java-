package ProducerAndConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        final Queue<Goods> queue = new LinkedList<>();
        final Integer maxGoods = 10;
        final Long speed = 500l;
        Producer producer = new Producer(queue,maxGoods,speed);
        Consumer consumer = new Consumer(queue,speed);
        Consumer consumer1 = new Consumer(queue,speed);
        Thread thread = new Thread(producer,"生产者");
        Thread thread1 = new Thread(consumer,"消费者1");
        Thread thread2 = new Thread(consumer1,"消费者2");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
