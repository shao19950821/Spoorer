package Thread;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 16:22 2018/8/30
 * @Modified By:
 */
public class SleepDemo {

    public void test() {
        synchronized(this) {
            System.out.println(Thread.currentThread().getName() + "进入了同步方法");
            System.out.println(Thread.currentThread().getName() + "准备sleep 2秒");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "sleep完了");
        }
    }

    public static void main(String[] args) {
        SleepDemo sleepDemo = new SleepDemo();
        Thread myThread1 = new Thread(new MyThread1(sleepDemo),"thread1");
        Thread myThread2 = new Thread(new MyThread1(sleepDemo),"thread2");
        myThread1.start();
        myThread2.start();

    }
}
class MyThread1 implements Runnable{

    private SleepDemo sleepDemo;

    public MyThread1(SleepDemo sleepDemo) {
        this.sleepDemo = sleepDemo;
    }

    @Override
    public void run() {
        sleepDemo.test();
    }
}
class MyThread2 implements Runnable{

    private SleepDemo sleepDemo;

    public MyThread2(SleepDemo sleepDemo) {
        this.sleepDemo = sleepDemo;
    }

    @Override
    public void run() {
        sleepDemo.test();
    }
}