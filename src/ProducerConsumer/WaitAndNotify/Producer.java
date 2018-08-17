package ProducerConsumer.WaitAndNotify;

/**
 * @Author: qixiang.shao
 * @Description: 生产者
 * @Date: Created in 22:27 2018/8/5
 * @Modified By:
 */
public class Producer implements Runnable{
    private Storage<Phone> storage;

    public Producer(Storage<Phone> storage) {
        this.storage = storage;
    }

    public void run() {
        for(int i = 0;i<20;i++){
            storage.produce(new Phone(i));

            try {
                Thread.sleep(10);//每隔10毫秒生产一个产品
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
