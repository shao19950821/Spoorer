package ProducerConsumer.WaitAndNotify;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 22:48 2018/8/5
 * @Modified By:
 */
public class Consumer implements Runnable {

    private Storage<Phone> storage;

    public Consumer(Storage<Phone> storage) {
        this.storage = storage;
    }

    public void run() {
        for(int i = 0;i<20;i++){
            storage.cosume();
            try {
                Thread.sleep(100);//每隔100毫秒消费一个
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
