package Thread;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 10:07 2018/8/12
 * @Modified By:
 */
public class Thread01Test {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new ListOff());
            thread.start();
        }
        System.out.println("Thread start");
    }
}

class ListOff implements Runnable {

    protected int countDown = 10;

    private static int taskCount = 0;

    private final int taskId = taskCount++;

    public ListOff() {
    }

    public ListOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        return "#" + taskId + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while (countDown-- > 0) {
            System.out.println(status());
            Thread.yield();
        }
    }
}
