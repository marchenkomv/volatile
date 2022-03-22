package task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

public class Main {
    private final static int SHOPS_COUNT = 10;
    private final static int MIN_PRICE = 1;
    private final static int MAX_PRICE = 500;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(SHOPS_COUNT);
        LongAdder array = new LongAdder();
        IntStream.range(MIN_PRICE, MAX_PRICE)
                .forEach(i -> executorService.submit(() -> array.add(i)));
        System.out.println("Результат: " + array.sum());
        executorService.shutdown();
    }
}