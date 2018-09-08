package jvm;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 22:49 2018/9/3
 * @Modified By:
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable throwable) {
            System.out.println(javaVMStackSOF.stackLength);
            throw throwable;
        }
    }
}
