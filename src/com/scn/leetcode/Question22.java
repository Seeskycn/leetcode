package com.scn.leetcode;

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
 * @Date: 2021/1/7 22:34
 * @Description:
 */
public class Question22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(4));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = getResult(n - 1, n, n,"(");

        return result;
    }

    private static List<String> getResult(int L, int R, int n, String path) {
        List<String> res = new ArrayList<>();
        if (L == 0) {
            String str = "";
            for (int i = 0; i < R; i++) {
                path += ")";
            }
            res.add(path);
            return res;
        }

        res.addAll(getResult(L - 1, R, n, path+"("));

        if (R > L) {
            res.addAll( getResult(L, R - 1, n, path+")"));

        }
        return res;
    }


}
