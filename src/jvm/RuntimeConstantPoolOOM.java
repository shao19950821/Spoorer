package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qixiang.shao
 * @Description: 方法区OOM
 * @Date: Created in 09:38 2018/9/4
 * @Modified By:
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
