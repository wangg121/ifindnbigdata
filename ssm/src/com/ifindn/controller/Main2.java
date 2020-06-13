package com.ifindn.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Guo Yan
 * @date 2020/6/3-23:30
 */
public class Main2 {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
//        sc.useDelimiter("\n");
//        int count = sc.nextInt();
//        for(int i =0;i<count;i++){
//            String str = sc.next();
//            String[] arrayStr = str.split(" ");
//            Integer[] arrInt = {Integer.valueOf(arrayStr[0]), Integer.valueOf(arrayStr[1])};
//            System.out.println(arrayStr[0]);
//        }

        List<Integer[]> list = new ArrayList<>();
        int count = in.nextInt();
        in.nextLine();
        for (int i = 0; i < count; i++) {
            String instr = in.nextLine();
            String[] arrayStr = instr.split(" ");
            Integer[] arrInt = {Integer.valueOf(arrayStr[0]), Integer.valueOf(arrayStr[1])};
            list.add(arrInt);
        }

    }


}
