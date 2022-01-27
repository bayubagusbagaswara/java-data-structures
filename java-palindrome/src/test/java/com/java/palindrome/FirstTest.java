package com.java.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest extends AbstractTest {

    // CARA 1: Membalikan data lalu membandingkan dengan data yang asli

    // function untuk cek Palindrome
    public boolean isPalindrome(String value) {

        // buat variable untuk menyimpan data hasil pembalikan datanya
        String temp = "";

        // perulangan dimulai dari yang paling belakang, jadi perlu tau penjang datanya
        // lalu masukkan tiap index[data] ke variable temp
        // perulangan dilakukan sampai datanya habis, alias sampai index ke-0
        // karena index itu mulai dari 0, maka nilai length selalu length-1

        for (int i = value.length()-1; i >= 0; i--) {
            // simpan
            temp = temp + value.charAt(i);
        }
        System.out.println(temp);
        return temp.equals(value);
    }

    @Test
    void readDataAndReverse() {
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
