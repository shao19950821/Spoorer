package Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 22:56 2018/8/8
 * @Modified By:
 */
public class LockTest {

    private Lock lock = new ReentrantLock();

    public void method(Thread thread) {

        if (lock.tryLock()) {
            try {
                System.out.println("线程名"+thread.getName() + "获得了锁");
            }catch(Exception e){
                e.printStackTrace();
            } finally {
                System.out.println("线程名"+thread.getName() + "释放了锁");
                lock.unlock();
            }
        }else{
            System.out.println("我是线程"+thread.getName()+"有人占着锁");
        }

    }

    public static void main(String[] args) {

        LockTest lockTest = new LockTest();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        },"t1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                lockTest.method(Thread.currentThread());
            }
        },"t2");

        thread1.start();

        thread2.start();

    }

}
