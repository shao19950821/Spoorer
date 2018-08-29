package ThreadLocal;


import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: ThreadLocal测试
 * @Date: Created in 15:04 2018/8/29
 * @Modified By:
 */
public class ThreadLocalTest {

    ThreadLocal<Long> longThreadLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };

    ThreadLocal<String> stringThreadLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };
    public void set() {
        longThreadLocal.set(Thread.currentThread().getId());
        stringThreadLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longThreadLocal.get();
    }

    public String getString() {
        return stringThreadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest threadLocalTest = new ThreadLocalTest();
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
        Thread thread1 = new Thread(){
            @Override
            public void run() {
                threadLocalTest.set();
                try {
                    TimeUnit.MILLISECONDS.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadLocalTest.getLong());
                System.out.println(threadLocalTest.getString());
            };
        };
        thread1.start();
        // thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。
        // 比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。
        thread1.join(1000);
        System.out.println(threadLocalTest.getLong());
        System.out.println(threadLocalTest.getString());
    }
}
