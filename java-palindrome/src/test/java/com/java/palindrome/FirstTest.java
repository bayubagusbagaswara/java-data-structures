package com.java.palindrome;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstTest extends AbstractTest {

    // CARA 1: Membalikan data lalu membandingkan dengan data yang asli

    // function untuk cek Palindrome
    public boolean isPalindrome(String value) {

        // buat variable temp untuk menyimpan data hasil pembalikan datanya
        // perulangan dimulai dari yang paling belakang, jadi perlu tau panjang string nya
        // lalu masukkan tiap karakter ke variable temp
        // perulangan dilakukan sampai stringnya habis dibaca, alias sampai index ke-0
        // karena index itu mulai dari 0, maka nilai length selalu length - 1

        String temp = "";

        for (int i = value.length()-1; i >= 0; i--) {
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
