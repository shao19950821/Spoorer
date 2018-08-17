package Synchronized;

import java.util.concurrent.locks.Lock;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 23:37 2018/8/2
 * @Modified By:
 */


public class TestSynchronized
{
    public void test1()
    {
        synchronized (TestSynchronized.class) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }

        }
    }

    public synchronized void test2()
    {
        int i = 5;
        while( i-- > 0)
        {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try
            {
                Thread.sleep(500);
            }
            catch (InterruptedException ie)
            {
            }
        }
    }

    public static void main(String[] args)
    {
        final TestSynchronized myt2 = new TestSynchronized();
        final TestSynchronized myt3 = new TestSynchronized();
        Thread test1 = new Thread(  new Runnable() {  public void run() { myt2.test1();  }  }, "test1"  );
        Thread test2 = new Thread(  new Runnable() {  public void run() { myt2.test2();   }  }, "test2"  );
        test1.start();
        test2.start();
    }

}
