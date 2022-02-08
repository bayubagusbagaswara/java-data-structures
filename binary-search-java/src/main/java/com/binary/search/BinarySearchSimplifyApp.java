package com.binary.search;

public class BinarySearchSimplifyApp {
    public static void main(String[] args) {
        Integer[] number = {1, 2, 5, 7, 8, 9, 12};
        int kunci = 5;
        int index = number.length / 2;
        boolean dataFounded = false;

        int tengah = index;
        while(index >= 0 && index < number.length && dataFounded == false) {
            if (kunci == number[index]) {
                System.out.println("Data ditemukan pada index ke-"+index);
                dataFounded = true;
            } else {
                if (kunci < number[tengah]) {
                    index--;
                } else {
                    index++;
                }
            }
        }

        if (dataFounded == false) {
            System.out.println("Data tidak ditemukan");
        }

    }
}
