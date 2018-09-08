package jvm;

/**
 * @Author: qixiang.shao
 * @Description: 循环引用GC
 * @Date: Created in 10:04 2018/9/4
 * @Modified By:
 */
public class ReferenceCountingGC {

    public Object instance = null;

    public static final int _1MB = 1024 * 1024;

    public byte[] bigSize = new byte[_1MB];

    public static void main(String[] args) {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();

    }
}
