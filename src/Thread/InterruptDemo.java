package Thread;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 17:34 2018/8/30
 * @Modified By:
 */
public class InterruptDemo {

    public static void main(String[] args) {
        Thread thread = new Thread(new MyThead(), "thread1");
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(thread.isInterrupted());
        System.out.println("-----------end-------------");
    }
}

class MyThead implements Runnable {

    @Override
    public void run() {
        System.out.println("1.方法执行");
        System.out.println("2.sleep 10s");
        try {
            // 线程休眠2s
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("3.sleep被打断，方法异常");
            e.printStackTrace();
            // 因为中断，所以要退出
            return;
        }
        System.out.println("4.方法正常结束");
    }
}
