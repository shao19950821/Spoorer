package Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: qixiang.shao
 * @Description: Callable 接口创建线程
 * @Date: Created in 10:23 2018/8/12
 * @Modified By:
 */
public class CallableDemo {
    public static void main(String[] args)  {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(executorService.submit(new MyTask(i)));
        }
        for (Future<String> future : futureList) {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}

class MyTask implements Callable<String>{

    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result is " + id;
    }
}
