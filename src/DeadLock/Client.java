package DeadLock;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 10:20 2018/8/19
 * @Modified By:
 */
public class Client {
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    LoggingWidget loggingWidget = new LoggingWidget();
                    loggingWidget.doSomething();
                }
            });
        }
    }
}
