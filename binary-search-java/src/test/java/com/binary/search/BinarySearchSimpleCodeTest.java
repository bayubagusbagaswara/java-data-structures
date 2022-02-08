package com.binary.search;

import org.junit.jupiter.api.Test;

public class BinarySearchSimpleCodeTest {

    @Test
    void testBinarySearchSimpleCode() {

        int[] numbers = {1, 2, 5, 7, 8, 9, 12};
        int key = 5;
        int middleIndex = numbers.length / 2;
        boolean haveFound = false;

        // 1. Tentukan range untuk perulangan datanya
        // yakni batas bawahnya adalah index-0 dan batas atasnya adalah length datanya
        // kondisi lain yang menentukan perulangan adalah saat nilai ketemu == false (artinya data belum ketemu)
        // selama masih dalam range, dan belum ketemu, maka lakukan perulangan terus
        // While ini memiliki kondisi perubahan nilainya di akhir (increment atau decrement dilakukan diakhir), lalu dicek lagi keatas

        int rangeData = middleIndex;

        while(rangeData >= 0 && rangeData < numbers.length && haveFound == false) {

            // 2. Jika data sama dengan nilai di tengah
            if (key == numbers[middleIndex]) {
                System.out.println("Data ditemukan pada index ke-"+middleIndex);
                haveFound = true;
            } else {
                // membagi panjang data menjadi 2 bagian, yakni untuk menentukan pencarian kebawah bawah atau keatas
                if (key < numbers[rangeData]) {
                    // pencarian di range bawah, menggunakan decrement
                    // fungsi increment dan decrement adalah sebagai pengubah nilai, dan akhirnya nanti perulangan bisa di stop
                    middleIndex--;
                } else {
                    // disini artinya pencarian keatas, menggunakan increment
                    middleIndex++;
                }
            }
        }

        if (haveFound == false) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
