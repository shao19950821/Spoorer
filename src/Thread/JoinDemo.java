package Thread;


import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 11:07 2018/8/31
 * @Modified By:
 */
public class JoinDemo {

    public static void main(String[] args) {
        Thread myThread1 = new Thread(new JoinThread(), "thread1");
        myThread1.start();
        try {
            myThread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----------end-----------");
    }
}

class JoinThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "print" + i);
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
