package com.scn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *-----------------神兽保佑 -----------------
 *           ┌─┐        ┌─┐
 *       ┌─┘  ┴────┘  ┴─┐
 *       │                        │
 *       │        ───          │
 *       │  ─┬┘       └┬─   │
 *       │                        │
 *       │       ─┴─           │
 *       │                        │
 *       └───┐          ┌──┘
 *               │          │
 *               │          │
 *               │          │
 *               │          └────────────┐
 *               │                                    │
 *               │                                    ├─┐
 *               │                                    ┌─┘
 *               │                                    │
 *               └─┐  ┐  ┌─────┬─┐  ┌──┘
 *                   │  ┤  ┤          │  ┤  ┤
 *                   └─┴─┘          └─┴─┘
 *
 * ------------------代码无BUG!--------------
 * @Author: Seesky
 * @Date: 2021/1/20 22:12
 * @Description:
 */
public class Question49 {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public static  List<List<String>> groupAnagrams(String[] strs) {
        Map<Character,Integer> map = new HashMap<>();
        Map<String,List<String>> resultMap = new HashMap<>();
        int j = 0;
        for (char i = 'a' ; i <='z'; i+=1){
            map.put(i,j );
            j++;
        }
        for (String str : strs) {
            char[] chars = new char[26];
            for (int i = 0; i < str.length(); i++) {
                Integer index = map.get(str.charAt(i));
                if(chars[index] != '1'){
                    chars[index]='1';
                }else {
                    chars[index] = '1'+1;
                }
            }
            String key = new String(chars);
            if (resultMap.get(key) == null) {
                List<String> list = new ArrayList<>();
                list.add(str);
                resultMap.put(key,list);
            }else {
                resultMap.get(key).add(str);
            }

        }

        return new ArrayList<>(resultMap.values());

    }


}
