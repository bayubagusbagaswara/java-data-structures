package com.binary.search;

import org.junit.jupiter.api.Test;

class BinarySearchTests {

	@Test
	void testBinarySearch() {

		// deklarasi data
		int number[]= {1, 2, 5, 7, 8, 9, 12};

		// tentukan key atau nilai yang akan dicari
		int key = 20;

		// cari titik yang ada di tengah
		// caranya adalah jumlahData dibagi 2
		int index = number.length / 2;

		// hasil dari integer adalah bulat, meskipun hasil bagi 2 adalah pecahan

		boolean ketemu = false; // untuk memberitahu apakah datanya ditemukan atau tidak

		// langkah pertama, membandingkan antara key dengan nilai yang ada ditengah
		if (key == number[index]) {
			System.out.println("Data ditemukan pada index ke-"+index);
			// lalu set ketemu menjadi true, artinya sudah ditemukan
			ketemu = true;
		} else {
			if (key < number[index]) {
				// cek apakah 2 < 7
				// jika true, maka akan dilakukan pencarian di separuh data awal
				// maka kita lakukan perulangan
				// disini index yang masuk adalah index ke-3, karena index 3 sudah pasti true, maka index-1
				for (int i = index-1; i >= 0; i--) {
					// decrement agar pengulangan ke bawah sampai index ke-0
					if (key == number[i]) {
						System.out.println("Data ditemukan pada index ke-"+i);
						ketemu = true;
						break;
					}
				}
			} else {
				// jika key < number[index] bernilai false
				// misal key 9, maka 9 < 7 adalah false
				for (int i = index+1; i < number.length; i++) {
					if (key == number[i]) {
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

	@Test
	void testBinarySearchSimpleCode() {

		int[] angka = {1, 2, 5, 7, 8, 9, 12};
		int kunci = 5;
		int index = angka.length / 2;
		boolean ketemu = false;

		// tentukan range untuk perulangan datanya yakni batas bawahnya adalah index-0 dan batas atasnya adalah jumlahDatanya (length)
		// kondisi lain yang menentukan perulangan adalah saat ketemu == false (artinya data belum ketemu)
		// selama masih dalam range, dan belum ketemu, maka lakukan perulangan terus
		int tengah = index;
		while(index >= 0 && index < angka.length && ketemu == false) {
			if (kunci == angka[index]) {
				// jika data yang dicari itu sama dengan data pada index tersebut
				System.out.println("Data ditemukan pada index ke-"+index);
				ketemu = true;
			} else {
				// else disini untuk membagi panjang data menjadi 2, dan menentukan pencarian di bawah atau diatas
				if (kunci < angka[tengah]) {
					// pencarian di range bawah atau menurun, jadi decrement
					// fungsi increment dan decrement adalah sebagai pengubah nilai
					// dan akhirnya nanti perulangan bisa di stop
					index--;
				} else {
					// pencarian keatas atau increment
					index++;
				}
			}
		}

		if (ketemu == false) {
			System.out.println("Data tidak ditemukan");
		}
	}
}
