package com.scn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-13
 */
public class Question12 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(intToRoman(num));
    }

    public static  String intToRoman(int num) {
        Map<Integer, String> map = getMap();
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (num>10){
            int temp = num % 10;
            if(temp == 4){

            }
            num = num / 10;
        }
        list.add(num);
        return list.toString();
    }

    public static Map<Integer,String> getMap(){
        Map<Integer,String> map = new HashMap<>(7);
        map.put(1,"I");
        map.put(5,"V");
        map.put(10,"X");
        map.put(50,"L");
        map.put(100,"C");
        map.put(500,"D");
        map.put(1000,"M");
        return map;
    }


}
