package com.sequential.search;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SequentialSearchTextTest {

    private final static Logger log = LoggerFactory.getLogger(SequentialSearchTextTest.class);

    String[] name = {"Riyan", "Angga", "Yunus", "Gandu",  "Zarin", "Nita", "Qiana"};
    boolean founded = false;
    String key = "zarin";

    @Test
    void searchText() {
        // index = length-1
        for (int i = 0; i <= name.length-1; i++) {

            // kita menggunakan equalsIgnoreCase untuk text
            if (key.equalsIgnoreCase(name[i])) {
                log.info("Data = {}, ditemukan pada index ke-{}", key, i);
                founded = true;
                break;
            }
        }

        if (founded == false) {
            log.info("Data tidak ditemukan");
        }
    }
}
