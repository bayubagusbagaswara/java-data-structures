package com.java.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ThirdTest extends AbstractTest {

    // CARA 3: KITA TIDAK PERLU BACA SEMUA DATANYA, CUKUP BACA SAMPAI TENGAHNYA SAJA
    // misal KODOK
    // kita cukup baca samapi K dan O (dari disi depan) dan juga K dan O (dari sisi belakang)
    // KENAPA? KARENA KALO 5 DIBAGI 2 ITU HASILNYA 2
    // 0 : 4 => K : K
    // 1 : 3 => O : 0
    // dan index ke 2 itu cuma 1, jadi gak berpengaruh
    // intinya lebih menghemat waktu, karena tidak perlu baca data seluruhnya, hanya sampai data paling tengah

    public boolean isPalindrome(String value) {
        for (int i = 0; i < value.length() / 2; i++) {
            int indexAwal = i;
            int indexAkhir = value.length() - i - 1;
            log.info("{} : {}", indexAwal, indexAkhir);
            log.info("======");
            if (value.charAt(indexAwal) != value.charAt(indexAkhir)) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testSingleDataPalindrome() {
        isPalindrome("kodok");
    }

    @Test
    void testPalindrome() {
        Assertions.assertTrue(isPalindrome("a"));
        Assertions.assertTrue(isPalindrome("aba"));
        Assertions.assertTrue(isPalindrome("kodok"));

        Assertions.assertFalse(isPalindrome("ab"));
        Assertions.assertFalse(isPalindrome("bayu"));
        Assertions.assertFalse(isPalindrome("kodcok"));
        Assertions.assertFalse(isPalindrome("abab"));
    }
}
