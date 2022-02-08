package com.java.factorial;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactorialTest {

    private final static Logger log = LoggerFactory.getLogger(FactorialTest.class);

    public int factorialForLoops(int value) {
        // SPECIAL CASE, if value 0, -1, -2, result is 1
        // 0! = 1
        // 1! = 1
        // 2! = 2
        if (value <= 0) {
            return 1;
        }
        // starting with loop
        // maximum looping is 1
        int result = 1;
        for (int i = value; i >= 1; i--) {
            result = result * i;
        }
        return result;
    }

    public int factorialRecursive(int value) {
        // SPECIAL CASE
        if (value <= 0) {
            return 1;
        } else {
            // 5 * factorial(4)
            // 5 * 4 * factorial(3)
            // 5 * 4 * 3 * factorial(2)
            // 5 * 4 * 3 * 2 * factorial(1)
            // 5 * 4 * 3 * 2 * 1 * factorial(0)
            // end, 5 * 4 * 3 * 2 * 1 * 1
            // factorial(5) * factorial(4) * factorial(3) * factorial(2) * factorial(1) * factorial(0)
            // jadi nunggu selesai dulu eksekusi factorial(0) lalu kembali lagi ke 1, 2, 3, 4, 5
            int result = value * factorialRecursive(value - 1);
            log.info("Result : {}", result);
            return result;
        }
    }

    // total adalah total nilai factorialnya, dan selalu dimulai dari 1
    // value adalah index yang akan berubah-ubah
    public int factorialTailRecursive(int total, int value) {
        // disini kita tidak perlu menunggu function recursive selanjutnya
        // factorial(1, 5)
        // factorial(5, 4)
        // factorial(20, 3)
        // factorial(60, 2)
        // factorial(120, 1)
        // factorial(120, 0)
        if (value <= 0) {
            return total;
        } else {
            // 1 * 5, 5-1, total = 5
            // 5 * 4, 4-1, total = 20
            // 20 * 3, 3-1, total = 60
            // 60 * 2, 2-1, total = 120
            // 120 * 1, 1-1, total = 120
            // 120 * 0, 0-0. end
            log.info("Total: {}", total*value);
            return factorialTailRecursive(total * value, value - 1);
        }
    }

    @Test
    void testFactorialForLoops() {
        assertEquals(1, factorialForLoops(0));
        assertEquals(1, factorialForLoops(1));
        assertEquals(2, factorialForLoops(2));
        assertEquals(6, factorialForLoops(3));
        assertEquals(120, factorialForLoops(5));
    }

    @Test
    void testFactorialRecursive() {
        assertEquals(1, factorialRecursive(0));
        assertEquals(1, factorialRecursive(1));
        assertEquals(2, factorialRecursive(2));
        assertEquals(6, factorialRecursive(3));
        assertEquals(120, factorialRecursive(5));
    }

    @Test
    void testFactorialTailRecursive() {
        assertEquals(1, factorialTailRecursive(1,0));
        assertEquals(1, factorialTailRecursive(1, 1));
        assertEquals(2, factorialTailRecursive(1, 2));
        assertEquals(6, factorialTailRecursive(1, 3));
        assertEquals(120, factorialTailRecursive(1,5));
    }


    @Test
    void test() {
        assertEquals(120, factorialTailRecursive(1,5));
    }
}
