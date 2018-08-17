package JucUtil;

import java.lang.reflect.WildcardType;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 23:37 2018/8/8
 * @Modified By:
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < 4; i++) {
            new Writer(cyclicBarrier).start();

        }

    }

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "开始执行写入数据");
            Random random = new Random();
            try {
                TimeUnit.MILLISECONDS.sleep(random.nextInt(4000));
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }

    }
}
