package ProducerConsumer.Concurrent;

/**
 * @Author: qixiang.shao
 * @Description: 产品类
 * @Date: Created in 22:28 2018/8/6
 * @Modified By:
 */
public class Product {

    private final int id;

    public Product(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Product" + this.id;
    }
}
