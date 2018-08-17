package Counter;

import sun.misc.Unsafe;

import java.io.Serializable;
import java.lang.reflect.Field;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 15:18 2018/7/27
 * @Modified By:
 */
public class CasCounter implements Serializable {
    public static Unsafe unsafe;

    public CasCounter() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(Unsafe.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CasCounter casCounter = new CasCounter();
    }
}
