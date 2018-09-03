package Thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 17:51 2018/8/30
 * @Modified By:
 */
public class InterruptDemo2 {

    public static void main(String[] args) throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(500);
        Thread.currentThread().interrupt();
        System.out.println("是否终止1？ =" + Thread.interrupted());
        System.out.println("是否终止2？ =" + Thread.interrupted());
        System.out.println("------------end------------");
    }
}