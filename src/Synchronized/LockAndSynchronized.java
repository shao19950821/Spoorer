package Synchronized;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: qixiang.shao
 * @Description: 同步和锁的区别
 *
 * @Date: Created in 16:42 2018/8/8
 * @Modified By:
 */
public class LockAndSynchronized  {

    public static void main(String[] args) throws InterruptedException {

        Thread t1=new Thread(new Thread1());
        t1.setName("t1");
        t1.start();
        Thread t2=new Thread(new Thread2());
        t2.setName("t2");
        t2.start();
        System.out.println("t1状态"+t1.getState());
        Thread.sleep(1000);
        System.out.println("t2状态"+t2.getState());
    }

}
class Thread1 implements Runnable{

    @Override
    public void run() {
        MyService.method();
    }
}

class Thread2 implements Runnable{

    @Override
    public void run() {
        MyService.method();
    }
}

class MyService {
    static Lock lock = new ReentrantLock();

    public /*synchronized*/ static void method() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + "==>执行");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }   finally {
            lock.unlock();
        }
    }
}

