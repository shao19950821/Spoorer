package DeadLock;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 10:20 2018/8/19
 * @Modified By:
 */
public class LoggingWidget extends Widget {
    @Override
    public synchronized void doSomething() {
        System.out.println("-----loggingWidget-----");
    }
}
