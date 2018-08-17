import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @Author: qixiang.shao
 * @Description: ArrayList和LinkedList尾插试验
 * @Date: Created in 23:29 2018/7/26
 * @Modified By:
 */
/*
LinkedList每次增加的时候，会new 一个Node对象来存新增加的元素，所以当数据量小的时候，这个时间并不明显，而ArrayList需要扩容，
所以LinkedList的效率就会比较高，其中如果ArrayList出现不需要扩容的时候，那么ArrayList的效率应该是比LinkedList高的，
当数据量很大的时候，new对象的时间大于扩容的时间，那么就会出现ArrayList'的效率比Linkedlist高了。
 */
public class ListAddTimeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            ArrayList arrayList = new ArrayList();
            LinkedList linkedList = new LinkedList();
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < num; i++) {
                arrayList.add(i);
            }
            long endTime = System.currentTimeMillis();
            System.out.println("ArrayList程序运行时间：" + (endTime - startTime) + "ms");    //输出程序运行时间

            long startTime1 = System.currentTimeMillis();    //获取开始时间

            for(int i=0;i<num;i++){
                linkedList.add(i);
            }   //测试的代码段

            long endTime1 = System.currentTimeMillis();    //获取结束时间

            System.out.println("LinkedList程序运行时间：" + (endTime1 - startTime1) + "ms");    //输出程序运行时间
        }
    }
}
