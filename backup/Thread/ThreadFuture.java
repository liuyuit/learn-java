package Thread;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//  java src/Thread/ThreadFuture.java
public class ThreadFuture {
    public static void main(String[] args) throws Exception {
        ExecutorService es = Executors.newFixedThreadPool(4);
        Future<BigDecimal> future = es.submit(new Task("601857"));
        System.out.println(future.get());
        es.shutdown();
    }
}


class Task implements Callable<BigDecimal> {
    String code;

    public Task(String code) {
        this.code = code;
    }

    @Override
    public BigDecimal call() throws Exception {
        Thread.sleep(1000);
        double d = 5 + Math.random() * 20;
        return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
    }
}
