package com.java.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SecondTest extends AbstractTest {

    // CARA 2 : TANPA MEMBUAT VARIABLE TEMPORARY, JADI COMPARE LANGSUNG
    // artinya tidak bikin variable yang menampung string reverse nya
    // sebenarnya tetap membaca data dari 2 arah, yakni dari depan dan dari belakang secara bersamaan
    // misal data ada 5 (k-o-d-o-k)
    // maka kita bandingkan data
    // 0 : 4
    // 1 : 3
    // 2 : 2
    // 3 : 1
    // 4 : 0
    // Tapi, masalahnya ini juga harus membaca semua data, kalau data nya banyak, maka akan membuang banyak waktu

    public boolean isPalindrome(String value) {
        // kita lakukan iterasi dari depan makanya harus increment
        for (int i = 0; i <= value.length()-1; i++) {

            int indexAwal = i;
            int indexAkhir = value.length() - i - 1; // kurangi i agar nilai index akhir menurun terus sampai index 0

            // cek apakah karakter dari index awal itu sama atau tidak dengan karakter dari index terakhir
            // misal KODOK
            // value[0] = K : value[4] = K (sama), lanjut perulangan
            // value[1] = O : value[3] = O (sama), lanjut perulangan
            // value[2] = D : value[2] = D (sama), lanjut perulangan
            // value[3] = O : value[1] = O (sama), lanjut perulangan
            // value[4] = K : value[0] = K (sama), stop perulangan, karena i > length

            if (value.charAt(indexAwal) != value.charAt(indexAkhir)) {
                // jika tidak sama, maka bukan palindrome
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
