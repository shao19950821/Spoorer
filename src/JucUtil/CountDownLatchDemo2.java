package JucUtil;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: (运动员赛跑)
 * @Date: Created in 13:16 2018/8/9
 * @Modified By:
 */
public class CountDownLatchDemo2 {

    public static void main(String[] args) {

        CountDownLatch start = new CountDownLatch(1);

        CountDownLatch end = new CountDownLatch(10);


        System.out.println("现在有10名运动员准备进行赛跑");

        for (int i = 0; i < 10; i++) {
            Thread runner = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("运动员" + Thread.currentThread().getName() + "站上了起跑线");
                        start.await();
                        System.out.println("运动员" + Thread.currentThread().getName() + "出发");
                        TimeUnit.MILLISECONDS.sleep(2000L);
                        System.out.println("运动员" + Thread.currentThread().getName() + "到达终点");
                        end.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            runner.start();
        }

        try {
            TimeUnit.MILLISECONDS.sleep(3000L);
            System.out.println("裁判发号施令，出发");
            start.countDown();
            end.await();
            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

