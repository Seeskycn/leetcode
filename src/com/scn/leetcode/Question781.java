package com.scn.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-03
 */
public class Question781 {
    public static void main(String[] args) {
        System.out.println(numRabbits(new int[]{1,1,1,0,0}));
    }
    public static int numRabbits(int[] answers) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int answer : answers) {
            if(map.get(answer) == null){
                map.put(answer,1);
            }else {
                map.put(answer,map.get(answer)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if(key == 0){
                count+=value;
            }else {
                int j = value / (key+1);
                if (value % (key+1) != 0) {
                    j++;
                }
                count += j * (key+1);
            }
        }
        return count;
    }
}
