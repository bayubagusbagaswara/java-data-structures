package com.binary.search;

import org.junit.jupiter.api.Test;

public class BinarySearchComplexCodeTest {

    @Test
    void testBinarySearch() {

        int[] numbers = {1, 2, 5, 7, 8, 9, 12, 20};

        // key adalah nilai yang dicari
        int key = 20;

        // cari titik tengah dulu, dengan cara jumlah data dibagi 2
        // hasil dari pembagian integer adalah bilangan bulat, meskipun hasil bagi 2 adalah pecahan, maka akan dibulatkan ke bawah
        int index = numbers.length / 2;
        System.out.println(index);

        // buat variable bertipe boolean, fungsinya untuk memberitahu apakah datanya berhasil ditemukan atau tidak
        boolean ketemu = false;

        // 1. bandingkan antara key dengan nilai yang ada ditengah. Ada kemungkingan nilai yang dicari itu kebetulan ada di data yang tengah
        if (key == numbers[index]) {
            System.out.println("Data ditemukan pada index ke-"+index);
            // lalu set ketemu menjadi true, artinya nilai sudah ditemukan
            ketemu = true;
        } else {
            // 2. Jika nilai yang dicari belum ketemu, artinya nilai tersebut ada dibawah atau diatas dari nilai tengah

            // 3. Jika nilai yang dicari itu kurang dari nilai tengah, maka lakukan pencarian kebawah, menggunakan decrement
            // index tengah = 3, artinya pencarian dimulai dari index ke-2 sampai index ke-0
            if (key < numbers[index]) {
                for (int i = index-1; i >= 0; i--) {
                    if (key == numbers[i]) {

                        System.out.println("Data ditemukan pada index ke-"+i);
                        ketemu = true;
                        // break langsung keluar dari program
                        break;
                    }
                }
            } else {
                // 4. Jika nilai yang dicari itu lebih dari nilai tengah, maka lakukan pencarian keatas, menggunakan increment
                // index tengah = 3, artinya pencarian dimulai dari index ke-4 sampai length datanya
                for (int i = index+1; i < numbers.length; i++) {
                    if (key == numbers[i]) {
                        // cek jika nilai yang dicari sesuai dengan numbers dengan index i
                        System.out.println("Data ditemukan pada index ke-"+i);
                        ketemu = true;
                        break;
                    }
                }
            }
        }
        if (ketemu == false) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
