package ProducerConsumer.WaitAndNotify;

/**
 * @Author: qixiang.shao
 * @Description: 产品-电话
 * @Date: Created in 22:28 2018/8/5
 * @Modified By:
 */
public class Phone {

    private int id;

    public Phone(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "手机编号：" + this.id;
    }
}
