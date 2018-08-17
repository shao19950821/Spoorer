package ProducerConsumer.Concurrent;

import java.text.MessageFormat;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: 消费者
 * @Date: Created in 23:44 2018/8/6
 * @Modified By:
 */
public class Consumer implements Runnable {

    private BlockingQueue<Product> productBlockingQueue;
    private static final int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<Product> productBlockingQueue) {
        this.productBlockingQueue = productBlockingQueue;
    }

    @Override
    public void run() {
        System.out.println("start Consumer id :" + Thread.currentThread().getId());
        Random random = new Random();
        try {
            while (true) {
                Product product = productBlockingQueue.take();
                if (product != null) {
                    int re = product.getId() * product.getId();
                    System.out.println(MessageFormat.format("{0}*{1}={2}", product.getId(), product.getId(), re));
                    TimeUnit.MILLISECONDS.sleep((long) random.nextInt(SLEEPTIME));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
