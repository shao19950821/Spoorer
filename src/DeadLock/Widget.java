package DeadLock;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 10:19 2018/8/19
 * @Modified By:
 */
public class Widget {
    public synchronized void doSomething() {
        System.out.println("----widget----");
    }
}
