package jvm;

/**
 * @Author: qixiang.shao
 * @Description: intern 方法测试
 * @Date: Created in 09:50 2018/9/4
 * @Modified By:
 */
public class InternMethodTest {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
    }
}
