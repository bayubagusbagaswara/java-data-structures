package com.java.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FourthyTest extends AbstractTest {

    /** CARA 4: GIMANA KALO TANPA PERULANGAN? BISA PAKE REKURSIF
     * jadi didalam function yang bertugas ngecek Palindrome, dia juga akan menjalankan function recursive
     */

    private boolean isPalindromeRecursive(String value, int index) {

        /* yang paling penting adalah kapan rekursif itu selesai
          kita cek jika menurut kondisi, dimana kondisi ini jika true, maka kita berhenti dari rekursif nya
         */

        // Misal KODOK, maka index harus < 2
        // jadi hanya dicek mulai dari index 0 sampai index 1
        if (index < value.length() / 2) {
            int indexAwal = index;
            int indexAkhir = value.length() - index - 1;

            /*
              kita cek, jika data dari kanan itu tidak sama dengan data dari kiri
              maka kita return false
              jadi berhenti perulangannya, karena data sudah tidak palindrome
             */
            if (value.charAt(indexAwal) != value.charAt(indexAkhir)) {
                return false; // bukan Palindrome
            } else {
                /*
                  nah disini kita panggil lagi rekursif nya
                  karena disini nilainya true, data dari kanan dan dari kiri itu nilainya sama
                  tapi disini kita naikan index nya, agar nilai perulangannya berganti
                 */
                return isPalindromeRecursive(value, index + 1);
            }
        } else {
            // disini rekursif nya sudah di cek semua, maka kita return true
            return true;
        }
    }

    // FUNCTION UNTUK CEK PALINDROME
    public boolean isPalindrome(String value) {
        // kita jalankan rekursif
        // dimulai dari index ke berapa untuk membaca datanya
        // misal mulai dari awal datanya yakni index ke-0
        return isPalindromeRecursive(value, 0);
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
