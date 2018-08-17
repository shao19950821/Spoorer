package JucUtil;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: CyclicBarrier和CountDownLatch 结合使用
 * @Date: Created in 14:31 2018/8/9
 * @Modified By:
 */
public class CountDownLatchAndCyclicBarrierDemo {

    static Random random = new Random();
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {

            }
        }); // 10个运动员
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            Thread runner = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        System.out.println("运动员" + Thread.currentThread().getName() + "进场");
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(4000));
                        cyclicBarrier.await();
                        System.out.println("运动员" + Thread.currentThread().getName() + "已经站在了起跑线上");
                        start.await();
                        System.out.println("运动员" + Thread.currentThread().getName() + "出发");
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(4000));
                        System.out.println("运动员" + Thread.currentThread().getName() + "到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }

                }
            }, String.valueOf(i));
            runner.start();
        }
        try {
            System.out.println("5s后发令枪响起，运动员出发");
            TimeUnit.MILLISECONDS.sleep(5000L);
            start.countDown();
            end.await();
            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
