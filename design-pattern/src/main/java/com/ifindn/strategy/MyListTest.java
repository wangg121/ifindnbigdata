package com.ifindn.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Mr.Guo
 * @Date 2020-09-13 18:55
 */
public class MyListTest {

    public static void main(String[] args) {
        List<String> array = new ArrayList<>();

        Integer a = new Integer(1);

        Collections.sort(array);

        Collections.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
    }
}
