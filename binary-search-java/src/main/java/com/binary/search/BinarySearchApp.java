package com.binary.search;

public class BinarySearchApp {
    public static void main(String[] args) {

        Integer[] number= {1, 2, 5, 7, 8, 9, 12};
        Integer searchKey = 9;
        Integer index = number.length / 2;
        boolean dataFounded = false;

        // PROSES PENCARIAN DATA

        if (searchKey.equals(number[index])) {
            System.out.println("Data ditemukan pada index ke-"+index);
            dataFounded = true;
        } else {
            if (searchKey < number[index]) {
                for (int i = index-1; i >= 0; i--) {
                    if (searchKey.equals(number[i])) {
                        System.out.println("Data ditemukan pada index ke-"+i);
                        dataFounded = true;
                        break;
                    }
                }
            } else {
                for (int i = index+1; i < number.length; i++) {
                    if (searchKey.equals(number[i])) {
                        System.out.println("Data ditemukan pada index ke-"+i);
                        dataFounded = true;
                        break;
                    }
                }
            }
        }
        if (dataFounded == false) {
            System.out.println("Data tidak ditemukan");
        }
    }
}
