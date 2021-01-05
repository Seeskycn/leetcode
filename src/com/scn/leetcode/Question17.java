package com.scn.leetcode;

import java.lang.reflect.Array;
import java.util.*;

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
 * @Date: 2021/1/5 22:34
 * @Description:
 */
public class Question17 {
    static Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public static void main(String[] args) {
        List<String> stringList = letterCombinations("2345");
        System.out.println(stringList + "" +stringList.size());
    }

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits == ""){
            return null;
        }
        char[] chars = digits.toCharArray();
        Arrays.sort(chars);
        return letterCombinations(chars, 0);

    }

    private static List<String> letterCombinations(char[] chars, int begin) {
        if (begin == chars.length - 1) {
            List<String> stringList = new ArrayList<>();
            for (char c : phoneMap.get(chars[begin]).toCharArray()) {
                stringList.add(c + "");
            }
            return stringList;
        }
        List res = new ArrayList();

        List<String> list = letterCombinations(chars, begin + 1);
        String phoneStr = phoneMap.get(chars[begin]);
        for (int j = 0; j < phoneStr.toCharArray().length; j++) {
            for (String str : list) {
                res.add(phoneStr.toCharArray()[j] + "".concat(str));
            }
        }

        return new ArrayList<>(res);
    }
}
