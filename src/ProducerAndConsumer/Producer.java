package ProducerAndConsumer;

import java.util.Queue;

public class Producer implements Runnable {

    private final Queue<Goods> goodsQueue;
    private final Integer maxGoods;
    private final Long speed;

    public Producer(Queue<Goods> goodsQueue, Integer maxGoods, Long speed) {
        this.goodsQueue = goodsQueue;
        this.maxGoods = maxGoods;
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
            synchronized (goodsQueue) {
                if (goodsQueue.size() >= maxGoods) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " 生产队列已满 等待消费 " + " 商品数目 " + goodsQueue.size());
                        Thread.sleep(speed);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Goods goods = new Goods("商品-", 500.0);
                    goodsQueue.add(goods);
                    System.out.println(Thread.currentThread().getName() + " 生产队列未满添加商品 " + goods +" 商品数目 " + goodsQueue.size());
                }
            }

        }

    }
}
