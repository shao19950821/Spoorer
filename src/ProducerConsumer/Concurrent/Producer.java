package ProducerConsumer.Concurrent;


import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qixiang.shao
 * @Description: 生产者
 * @Date: Created in 22:25 2018/8/6
 * @Modified By:
 */
public class Producer implements Runnable {

    private volatile boolean isRunning = true;

    private static final int SLEEPTIME = 1000;

    private BlockingQueue<Product> productBlockingQueue;

    private static AtomicInteger count = new AtomicInteger();// 总数 原子操作

    public Producer(BlockingQueue<Product> productBlockingQueue) {
        this.productBlockingQueue = productBlockingQueue;
    }

    @Override
    public void run() {
        Product product = null;
        System.out.println("start Producer id :" + Thread.currentThread().getId());
        Random random = new Random();
        try {
            while (isRunning) {

                long sleepTime = (long) random.nextInt(SLEEPTIME);
                TimeUnit.MILLISECONDS.sleep(sleepTime);

                product = new Product(count.incrementAndGet());

                System.out.println(product + " 加入队列，线程暂停了" + sleepTime + "ms");
                if (!productBlockingQueue.offer(product, 2, TimeUnit.SECONDS)) {
                    System.err.println(" 加入队列失败");
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        this.isRunning = false;
    }
}
