package Refrence;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 17:12 2018/8/5
 * @Modified By:
 */
public class StrongRefrence {
    static Object object = new Object();
    public static void main(String[] args) {
        Object obj = object;
        object = null;
        obj = null;
        System.gc();
        System.out.print("after system.gc-strongReference---obj = " + obj);

    }
}
