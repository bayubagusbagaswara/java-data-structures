package com.sequential.search;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialSearchNumberTest {

    private final static Logger log = LoggerFactory.getLogger(SequentialSearchNumberTest.class);

    // 1. buat sebuah variable untuk menyimpan kumpulan data
    // misalnya kumpulan String of integer dari 10 data
    int[] number = {5, 6, 9, 2, 8, 1, 7, 10, 15, 4};

    // 2. buat sebuah variable bertipe boolean, yang gunanya untuk memberi tahu apakah datanya ketemu atau tidak ketemu
    // default nya adalah false. Nanti kita ganti 'true' apabila datanya ketemu
    boolean founded = false;

    // 3. buat sebuah variable untuk menyimpan key (kunci) atau data yang akan dicari
    // misalnya kita cari data 8
    int key = 2;

    @Test
    void searchNumber() {
        // 1. Baca tiap data, dengan cara mengambil nilai tiap index nya
        // perulangan di inisialisasi dengan nilai i=0, karena kita mencari data mulai dari paling awal yakni index ke-0
        // sampai batas apa kita baca datanya? yakni sejumlah panjang data yang ingin dicari, yakni menggunakan length
        // misalnya panjang datanya ada 10, jadi datanya berada mulai dari index ke-0 sampai index ke-9
        // karena kita mulai dari index 0, maka length kita kurangin 1
        // dan perulangannya akan habis setelah length bernilai 9
        // lalu untuk mengubah index tiap perulangan, maka kita tambahkan increment

        for (int i = 0; i <= number.length - 1; i++) {

            // setelah kita baca 1 data, misalnya index[0]
            // lalu kita bandingkan dengan key atau data yang ingin kita cari. Apakah sama atau tidak datanya

            if (key == number[i]) {
                log.info("Data = {}, ditemukan pada index ke-{}", key, i);

                // setelah datanya ketemu, maka kita ubah nilai pada variable founded, gunanya untuk memberitahu bahwa datanya sudah ketemu
                founded = true;
                // lalu hentikan atau keluar dari perulangan
                break;
            }
        }

        // 2. Bagian dimana setelah kita melakukan perulangan membaca semua data, tetapi tetap tidak menemukan datanya
        // maka cukup cek kondisi founded, apakah masih bernilai false
        // jika nilainya false, maka bisa diartikan bahwa data tidak pernah ditemukan
        if (!founded) {
            log.info("Data tidak ditemukan");
        }
    }

    @Test
    void test() {
        int length = number.length;
        log.info("Length = {}", length);
        for (int i = 0; i <= length-1; i++) {
            log.info("Index = {}, Value = {}", i, number[i]);
            log.info("==========");
        }
    }
}
