/**
 * @Author: qixiang.shao
 * @Description: Synchronized锁实例锁对象测试
 * @Date: Created in 00:13 2018/7/27
 * @Modified By:
 */

public class TestSynchronized {

    public synchronized void test1() {

    }

    public void test2() {
        synchronized (this) {

        }
    }
}
