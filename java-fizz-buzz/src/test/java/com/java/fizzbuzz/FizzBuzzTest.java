package com.java.fizzbuzz;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FizzBuzzTest {

    private final static Logger log = LoggerFactory.getLogger(FizzBuzzTest.class);

    // buat function untuk fizzbuzz
    // buat perulangan 1-100
    public void fizzBuzz(int total) {
        for (int i = 1; i <= total; i++) {

            // 1. cek jika index nya bisa dibagi 3 dan 5
            if (i%3==0 && i%5==0) {
                System.out.println("val-"+i+" = "+"FizzBuzz");
            } else if (i%3 == 0) {
                // 2. jika index habis dibagi 3
                System.out.println("val-"+i+" = "+"Fizz");
            } else if (i%5 == 0) {
                // 3. jka index habis dibagi 5
                System.out.println("val-"+i+" = "+"Buzz");
            } else {
                // kondisi selain diatas
                System.out.println("val-"+i+" = "+i);
            }
        }
    }

    @Test
    void testFizzBuzz() {
        fizzBuzz(100);
    }
}
