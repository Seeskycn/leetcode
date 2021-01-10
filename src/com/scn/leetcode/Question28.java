package com.scn.leetcode;

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
 * @Date: 2021/1/10 19:18
 * @Description:
 */
public class Question28 {
    public static void main(String[] args) {
        System.out.println(strStr("", ""));
    }
    public static int strStr(String haystack, String needle) {
        if (needle == "" || needle == null ) {
            return 0;
        }
        if(haystack == null || haystack.length() == 0  ||haystack.length() < needle.length()){
            return -1;
        }

        for (int i = 0; i < haystack.length()-needle.length()+1; i++) {
            int index = i;
            if(haystack.charAt(index) == needle.charAt(0)){
                index++;
                for (int j = 1; j < needle.length(); j++) {
                    if(haystack.charAt(index) == needle.charAt(j)){
                        if(j == needle.length()-1){
                            return i;
                        }
                        index++;
                    }else {
                        break;
                    }
                }
            }
        }
        return -1;
    }

}
