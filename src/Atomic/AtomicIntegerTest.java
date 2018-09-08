package Atomic;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: qixiang.shao
 * @Description: 原子自增
 * @Date: Created in 23:36 2018/8/29
 * @Modified By:
 */
public class AtomicIntegerTest {

    private static AtomicInteger atomicInteger = new AtomicInteger();

    private final static int THREAD_COUNT = 20;

    public void increase() {
        atomicInteger.incrementAndGet();
    }

    public static void main(String[] args) {
        Executor executors = Executors.newFixedThreadPool(THREAD_COUNT);
    }
}
