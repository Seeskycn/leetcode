package com.scn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-12
 */
public class Manachar {

    public static void main(String[] args) {

        for (int i : getInt("abcbc")) {
            System.out.print(i + " ");
        }

    }


    public static int[] getInt(String str){
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add('#');
            list.add(str.charAt(i));
        }
        list.add('#');
        int[] arr = new int[list.size()];
        int R = -1;
        int cur = -1;
        for (int i = 0; i < list.size(); i++) {
            if (i>R) {
                int left = i -1;
                int right = i + 1;
                while (left >=0 && right<list.size()){
                    if(list.get(left).equals(list.get(right))){
                        left = left -1;
                        right = right-1;
                    }else {
                        break;
                    }
                }
                R = right-1;
                cur = i;
                arr[i] = R-i;
            }else {
                // 获得i 关于 cur 的对称点
                int i2 = cur-(i-cur);
                int r2 = arr[i2];
                int indexR2 = i2- r2;
                int L = cur - arr[cur];
                if(indexR2 > L){
                    arr[i] = r2;
                }else if(indexR2 < L){
                    arr[i] = R -i;
                }else {
                    int left = indexR2 -1;
                    int right = R+1;
                    while (left >=0 && right<list.size()){
                        if(list.get(left).equals(list.get(right))){
                            left = left -1;
                            right = right-1;
                        }else {
                            break;
                        }
                    }
                    R = right-1;
                    cur = i;
                    arr[i] = R-i;
                }


            }
        }


        return arr;

    }
}
