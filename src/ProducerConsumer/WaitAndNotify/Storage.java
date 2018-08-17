package ProducerConsumer.WaitAndNotify;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 22:29 2018/8/5
 * @Modified By:
 */
public class Storage<T> {

    private int index = 0;
    public static final int MAX = 10; // 最大容量
    private List<T> productList = new ArrayList<>(MAX); // 存储商品的集合

    public synchronized void produce(T item) {
        while (index >= MAX) {
            try {
                System.out.println("仓库满了,暂停生产");
                this.wait();
                System.out.println("仓库不满了，开始生产");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生产>>" + item.toString());
        productList.add(item);
        index++;   //先添加item，在进行加1操作
        notify();  //唤醒在此对象监视器上等待的单个线程，即消费者线程
    }

    public synchronized T cosume() {
        while (index <= 0) {
            try {
                System.out.println("仓库为空，等待中...");
                this.wait();
                System.out.println("仓库不为空，开始消费");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        index--;//先进行减1操作，再remove
        T item = productList.remove(index);
        System.out.println("消费>>" + item.toString());
        notify();
        return item;
    }
}
