package ProducerConsumer.Concurrent;

import java.util.concurrent.*;

/**
 * @Author: qixiang.shao
 * @Description: 测试方法
 * @Date: Created in 23:46 2018/8/6
 * @Modified By:
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Product> productBlockingDeque = new LinkedBlockingQueue<>(10);
        ExecutorService service = Executors.newCachedThreadPool();
        Producer p1 = new Producer(productBlockingDeque);
        Producer p2 = new Producer(productBlockingDeque);
        Producer p3 = new Producer(productBlockingDeque);
        Consumer c1 = new Consumer(productBlockingDeque);
        Consumer c2 = new Consumer(productBlockingDeque);
        Consumer c3 = new Consumer(productBlockingDeque);
        service.execute(p1);
        service.execute(p2);
        service.execute(p3);
        service.execute(c1);
        service.execute(c2);
        service.execute(c3);
        long a =System.currentTimeMillis();
        TimeUnit.MILLISECONDS.sleep(10000);
        long b = System.currentTimeMillis();
        System.out.println(b - a);
        p1.stop();
        p2.stop();
        p3.stop();
        service.shutdown();

    }
}
