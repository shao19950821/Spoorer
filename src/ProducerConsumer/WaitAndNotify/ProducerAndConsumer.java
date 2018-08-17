package ProducerConsumer.WaitAndNotify;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 22:49 2018/8/5
 * @Modified By:
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
        Storage<Phone> storage = new Storage<Phone>();

        new Thread(new Producer(storage)).start();
        new Thread(new Consumer(storage)).start();
    }
}
