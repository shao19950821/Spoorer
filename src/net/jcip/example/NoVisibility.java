package net.jcip.example;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 23:19 2018/8/19
 * @Modified By:
 */
public class NoVisibility {
    private static boolean ready;
    private static int number;

    private static class MyThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                Thread.yield();
            }
                System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new MyThread().start();
        ready = true;
        number = 42;
    }
}
