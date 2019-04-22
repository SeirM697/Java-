package ProducerAndConsumer;

import java.util.Queue;

public class Consumer implements Runnable {
    private final Queue<Goods> goodsqueue;

    private final Long speed;

    public Consumer(Queue<Goods> goodsqueue, Long speed) {
        this.goodsqueue = goodsqueue;
        this.speed = speed;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (goodsqueue) {
                if (goodsqueue.isEmpty()) {
                    System.out.println(Thread.currentThread().getName() + " 生产队列以空 通知生产 ");
                    goodsqueue.notifyAll();
                } else {
                    Goods goods = goodsqueue.poll();
                    if (goods != null) {
                        System.out.println(Thread.currentThread().getName() + " 队列有商品可消费 " + goods+ " 商品数目 " +goodsqueue.size());
                    }

                }
            }
        }
    }
}
