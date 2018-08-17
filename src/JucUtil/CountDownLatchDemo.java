package JucUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: CountDownLatch(多线程并行执行，由主线程发号施令)
 * @Date: Created in 23:56 2018/8/8
 * @Modified By:
 */


class WaitingTask implements Runnable {

    private CountDownLatch countDownLatch;

    public WaitingTask(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {

            System.out.println(Thread.currentThread().getName()+"任务开始执行");

            System.out.println(Thread.currentThread().getName()+"任务等待");

            countDownLatch.await();

            System.out.println(Thread.currentThread().getName()+"任务执行结束");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class CountDownLatchDemo {

    private static final int SIZE = 1;


    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(SIZE);

        System.out.println("开启100个线程");

        for (int i = 0; i < 100; i++) {
            new Thread(new WaitingTask(countDownLatch)).start();

        }

        TimeUnit.MILLISECONDS.sleep(5000L);

        System.out.println("主线程发令，各个线程继续执行");

        countDownLatch.countDown();
        countDownLatch.countDown();

    }

}
