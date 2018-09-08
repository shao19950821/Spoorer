package jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author: qixiang.shao
 * @Description: JConsole 测试
 * @Date: Created in 14:20 2018/9/8
 * @Modified By:
 */
public class MonitoringTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fileeHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TimeUnit.MILLISECONDS.sleep(50);
            list.add(new OOMObject());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        fileeHeap(1000);
        System.gc();
    }
}
