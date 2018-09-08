package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 10:46 2018/8/31
 * @Modified By:
 */
public class YieldDemo {

    public static void printNumber() {

        for (int i = 0; i < 50; i++) {
            System.out.println(Thread.currentThread().getName() + "print:" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 30) {
                // 当i==30时，让给其他线程执行
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {

        Thread myThread1 = new Thread(new YieldThread(), "thread1");
        Thread myThread2 = new Thread(new YieldThread(), "thread2");
        myThread1.start();
        myThread2.start();
    }

}

class YieldThread implements Runnable {

    @Override
    public void run() {
        YieldDemo.printNumber();
    }
}
