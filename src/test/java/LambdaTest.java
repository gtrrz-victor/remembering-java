import org.junit.Test;

import java.util.concurrent.*;

public class LambdaTest {

    private final Callable<Boolean> waitFiveSeconds = () -> {
        System.out.println("Starting callable");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("5 seconds later...");
        return true;
    };

    @Test
    public void myFirstFutureTest() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executor.submit(waitFiveSeconds);
        System.out.println("isDone:"+future.isDone());
        System.out.println("wait until done");
        future.get();
        System.out.println("isDone:"+future.isDone());
    }

    @Test
    public void forceCancellingFutureTest() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executor.submit(waitFiveSeconds);
        System.out.println("isDone:"+future.isDone());
        System.out.println("wait until done");
        future.cancel(true);
        System.out.println("isDone:"+future.isDone());
        System.out.println("isCancelled:"+future.isCancelled());
    }

    @Test
    public void cancellingFutureTest() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Boolean> future = executor.submit(waitFiveSeconds);
        System.out.println("isDone:"+future.isDone());
        System.out.println("wait until done");
        future.cancel(false);
        System.out.println("isDone:"+future.isDone());
        System.out.println("isCancelled:"+future.isCancelled());
    }
}
