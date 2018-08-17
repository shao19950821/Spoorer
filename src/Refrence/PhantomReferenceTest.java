package Refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    static Object object = new Object();
    static String str = "strTest";
    public static void main(String[] args) {
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(object,referenceQueue);
        PhantomReference<Object> phantomReferenceStr = new PhantomReference<>(str,referenceQueue);
//        object = null;
//        str = null;
        System.gc();
        System.out.println("after system.gc---phantomReference = " + phantomReference.get());
        System.out.println("after system.gc---phantomReferenceStr = " + phantomReferenceStr.get());

    }

}