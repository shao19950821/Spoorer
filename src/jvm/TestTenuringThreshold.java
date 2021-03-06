package jvm;

/**
 * o'm
 *
 * @Author: qixiang.shao
 * @Description: 老年代GC年龄测试
 * @Date: Created in 15:05 2018/9/4
 * @Modified By:
 */
public class TestTenuringThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        TestTenuringThreshold.testTenuringThreshold();
    }

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation4 = new byte[4 * _1MB];
    }
}
