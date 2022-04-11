package stream.create;

import java.io.IOException;
import java.util.function.LongSupplier;
import java.util.stream.LongStream;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * java src/stream/create/Main.java
 *
 * @author liaoxuefeng
 */
public class Main {
    public static void main(String[] args) throws IOException {
        LongStream fib = LongStream.generate(new FibSupplier());
        // 打印Fibonacci数列：1，1，2，3，5，8，13，21...
        fib.limit(10).forEach(System.out::println);
    }
}

class FibSupplier implements LongSupplier {
    protected int previousNumber = 0;
    protected int currentNumber = 1;

    public long getAsLong() {
        if (previousNumber == 0) {
            previousNumber = currentNumber;
            return currentNumber;
        }
       int resultInt = previousNumber + currentNumber;

        int previousNumberBefore = previousNumber;
        previousNumber = currentNumber;
        currentNumber += previousNumberBefore;

        return resultInt;
    }
}
//
//class FibSupplier implements LongSupplier {
//    protected int previousNumber = 0;
//    protected int currentNumber = 1;
//
//    public long getAsLong() {
//        int resultInt;
//        resultInt = previousNumber + currentNumber;
//
//        int previousNumberBefore = previousNumber;
//        previousNumber = currentNumber;
//        currentNumber += previousNumberBefore;
//
//        return resultInt;
//    }
//}
