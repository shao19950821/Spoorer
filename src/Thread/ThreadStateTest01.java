package Thread;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 16:13 2018/8/4
 * @Modified By:
 */
public class ThreadStateTest01 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.setThread2(t2);

        t1.start();
        t2.start();
    }
}
//Thread1负责打印两个线程的状态。
class Thread1 extends Thread
{
    private Thread2 t2;

    public void setThread2(Thread2 t2)
    {
        this.t2 = t2;
    }

    @Override
    public void run()
    {
        System.out.println("进入t1线程");
        for(int i = 0; i < 5; i++)
        {
            try
            {
                System.out.println("t1 的状态： " + getState());
                System.out.println("t2 的状态： " + t2.getState());
                System.out.println();

                //为了减少打印次数，所以t1每打印一次睡1秒
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {

            }
        }
    }
}

class Thread2 extends Thread
{
    @Override
    public void run()
    {
        System.out.println("进入t2线程，马上进入睡眠");
        try
        {
            //睡眠5秒钟。
            sleep(5000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("t2睡眠结束");
    }
}