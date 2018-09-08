package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: qixiang.shao
 * @Description: jvm oom测试
 * @Date: Created in 23:41 2018/9/2
 * @Modified By:
 */
public class HeapOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }

    }
}
