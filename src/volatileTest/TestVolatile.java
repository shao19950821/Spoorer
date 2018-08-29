package volatileTest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 23:44 2018/8/22
 * @Modified By:
 */
public class TestVolatile {
    public  int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final TestVolatile test = new TestVolatile();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }


        System.out.println(test.inc);
    }
}
