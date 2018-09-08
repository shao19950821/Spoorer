package jvm.指令重拍;

/**
 * @Author: qixiang.shao
 * @Description:
 * @Date: Created in 14:39 2018/7/22
 * @Modified By:
 */
public class PossibleReordering {
    static int x = 0, y = 0;
    static int a = 0, b = 0;

    public static void main(String[] args) throws InterruptedException {

        while (true) {
            Thread one = new Thread(new Runnable() {
                public void run() {
                    a = 1;
                    x = b;
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    b = 1;
                    y = a;
                }
            });
            one.start();
            other.start();
            System.out.println("(" + x + "," + y + ")");
            if(x == 0 && y ==0){
                break;
            }
        }
    }
}