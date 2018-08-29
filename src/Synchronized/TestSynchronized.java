package Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: 类锁和对象锁
 * @Date: Created in 23:37 2018/8/2
 * @Modified By:
 */


public class TestSynchronized {
    public void test1() {
        synchronized (TestSynchronized.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static synchronized void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(new Runnable() {
            @Override
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            @Override
            public void run() {
                TestSynchronized.test2();
            }
        }, "test2");
        test1.start();
        test2.start();
    }

}
