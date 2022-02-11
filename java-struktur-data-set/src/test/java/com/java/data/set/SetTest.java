package com.java.data.set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class SetTest {

    private final static Logger log = LoggerFactory.getLogger(SetTest.class);

    // bikin class untuk Set
    public static class Set {

        // saat ini ada berapa jumlah datanya
        // kenapa kita harus mengecek jumlah datanya?
        // karena kita tidak mungkin menggunakan panjang array, oleh itu kita buat counter untuk mengetahui size set saat ini
        private int size = 0;

        // kita harus simpan datanya kedalam Array
        // kenapa? karena di array kan kita bisa nambahin datanya, misal kita beri default arraynya adalah 10
        private String[] array = new String[10];

        // setelah kita akan menambahkan data ke set, tapi kita cek dulu apakah datanya sudah ada atau belum
        // kalau belum ada, maka kisa bisa tambahkan datanya


        // kita butuh method yaitu add()
        // boolean artinya untuk mengetahui data yang kita tambahkan ke set itu berhasil atau gagal
        // return true berarti sukses add data
        public boolean add(String value) {
            // cek apakah value yang kita tambahkan itu ada di set atau belum
            if (contains(value)) {
                // jika sama/contains, artinya tidak bisa ditambahin, karena datanya sudah ada, data tidak boleh duplikat
                return false;
            } else {
                // jika valuenya tidak ada yang contains, maka kita tambahkan datanya ke set
                // tapi pastikan dulu kapasitas arraynya, karena jika arraynya sudah maksimal, maka akan dibuatkan array baru
                // dengan syarat disini kita sudah menerapkan penggeseran data di set nya
                ensureCapacity();
                // misal array[15] maka kita tambahkan kedalam array index ke-15
                array[size] = value;
                // lalu tambahkan size setnya, karena datanya sudah bertambah, dan saat kita add data lagi, maka akan dimasukkan ke index selanjutnya
                size++;
                // true, artinya berhasil ditambahkan
                return true;
            }
        }

        // function untuk bantuan mengecek/memastikan kapasitas arraynya, jika sudah melebihi kapasitas defaultnya, maka akan dibuatkan array baru
        // lalu kita akan meng-copy data di array lama ke array baru
        // kapasitas array baru adalah 2x lipat dari array sebelumnya
        private void ensureCapacity() {
            if (size >= array.length) {
                String[] temp = new String[array.length * 2];
                for (int i = 0; i < array.length; i++) {
                    temp[i] = array[i];
                }
                // ubah array nya, array[20]
                array = temp;
            }
        }

        // kita lakukan pengecekan apakah datanya sudah ada sebelumnya atau belum
        // buat perulangan untuk cek item di arraynya
        // jika value sudah ada di array set maka kita return true, karena benar emang datanya sudah ada
        public boolean contains(String value) {
            for (String item : array) {
                if (value.equals(item)) {
                    return true;
                }
            }
            return false;
        }

        // kita bisa mengecek jumlah data yang ada di dalam Set nya
        // kenapa? karena setelah kita tambahin data, maka kita harus tau data didalamnya sudah berapa yang tersimpan
        public int size() {
            return size;
        }

        // function bantuan untuk cek index dari value (data yang dimasukkan)
        // jika value sama dengan array[index], maka balikkan nilai index
        private int indexOf(String value) {
            // misal length = 10
            for (int i = 0; i < array.length; i++) {
                // cek value dengan data di array berdasarkan index
                if (value.equals(array[i])) {
                    return i;
                }
            }
            return -1;
        }

        // kita bisa menghapus datanya
        // kita tidak menghapus seperti array dengan menggunakan index
        // di set gabisa pake index, karena di set itu tidak jelas urutannya
        public boolean remove(String value) {
            // cek datanya apakah ada di set nya atau tidak
            if (contains(value)) {
                // [Bayu, Bagus, Bagaswara, Aan, Putra, null, null, null]
                // saat menghapus data Bagus, jadi [Bayu, null, Bagaswara, Aan, Putra, null, null, null]
                // untuk menghapus data, tidak asal langsung menghapus, harus kita geser dulu datanya,
                // karena saat awal size nya 10, dan datanya misal ada 10, dan jika kita menghapus 1 data, maka tinggal 9 data
                // masalahnya jika kita menghapus data pada index ke-2 misalnya, maka index ke-2 bernilai null, lalu saat kita menambahkan data baru, maka bisa saja menimpa data yang lama (override)
                // maka caranya harus kita geser dulu datanya

                // buat indexRemoved adalah data yang di removed berdasarkan index
                // misal 10 = 10
                // perulangan dimulai dari 10, dan sebanyak sizenya
                // misalnya kita hapus data di index ke 2, maka perulangan dimulai dari 2, dan menggeser data index ke-3 menjadi index-2, dan seterusnya sampai semua data/panhang arraynya
                int indexRemoved = indexOf(value);
                for (int i = indexRemoved; i <= size; i++) {
                    array[i] = array[i+1];
                }
                // selesai dihapus, maka turunin size setnya, agar nantinya bisa kita ketahui ukuran size saat ini
                size--;
                return true;
            } else {
                // tidak remove
                return false;
            }
        }
    }

    @Test
    void testAdd() {
        Set set = new Set();
        Assertions.assertTrue(set.add("Bayu"));
        Assertions.assertFalse(set.add("Bayu"));
        Assertions.assertTrue(set.add("Bagus"));
        Assertions.assertFalse(set.add("Bagus"));
    }

    @Test
    void testContains() {
        Set set = new Set();
        set.add("Bayu");
        set.add("Bagus");

        Assertions.assertTrue(set.contains("Bayu"));
        Assertions.assertTrue(set.contains("Bagus"));
        Assertions.assertFalse(set.contains("Bagaswara"));
    }

    @Test
    void testSize() {
        Set set = new Set();
        Assertions.assertEquals(0, set.size);
        set.add("Bayu");
        Assertions.assertEquals(1, set.size);
        set.add("Bayu");
        Assertions.assertEquals(1, set.size);
        set.add("Bagaswara");
        Assertions.assertEquals(2, set.size);
    }

    @Test
    void testRemove() {
        Set set = new Set();
        set.add("Bayu");
        set.add("Bagus");
        set.add("Bagaswara");
        set.add("Aan");
        set.add("Putra");
        set.add("Setya");

        Assertions.assertEquals(6, set.size);

        set.remove("Bagaswara");
        Assertions.assertEquals(5, set.size);
        Assertions.assertTrue(set.contains("Bayu"));
        Assertions.assertTrue(set.contains("Bagus"));
        Assertions.assertTrue(set.contains("Aan"));
        Assertions.assertTrue(set.contains("Putra"));
        Assertions.assertTrue(set.contains("Setya"));
        Assertions.assertFalse(set.contains("Bagaswara"));
    }

    @Test
    void testGrowth() {
        Set set = new Set();
        for (int i = 0; i < 100; i++) {
            set.add("Item-" + i);
        }
        Assertions.assertEquals(100, set.size);
    }

}
