package com.ifindn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guo Yan
 * @date 2020/6/3-23:06
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

//        sc.useDelimiter("\n");

        List<Integer[]> list = new ArrayList<>();


        int count = in.nextInt();


        for (int i = 0; i < count; i++) {
            String instr = in.nextLine();
            String[] arrayStr = instr.split(" ");
            Integer[] arrInt = {Integer.valueOf(arrayStr[0]), Integer.valueOf(arrayStr[1])};
            list.add(arrInt);
        }
        for (int i = 0; i < list.size() - 1; i++) {

            Integer[] arrInt1 = list.get(i);
            Integer[] arrInt2 = list.get(i + 1);

            if (arrInt1[1].intValue() == arrInt2[0].intValue()) {
                System.out.println(arrInt1[1] + " " + arrInt2[0]);
            } else if (arrInt1[0] <= arrInt2[0] && arrInt1[1] <= arrInt2[1] && arrInt1[1] > arrInt2[0]) {
                System.out.println(arrInt2[0] + " " + arrInt1[1]);
            } else {
                System.out.println("none");
            }

        }


    }

}
