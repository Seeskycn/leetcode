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
 * @Date: 2021/3/3 21:32
 * @Description:
 */
public class Offer14I {

    public static void main(String[] args) {
        System.out.println(cuttingRope(10));
    }

    public static int cuttingRope(int n) {

        int max = 0;
        for (int i = 2; i <= n; i++) {
            max = Math.max(max,cut(n,i));
        }
        return max;
    }

    private static int cut(int n, int i) {
        int num = 1;
        while (n % i != 0 ){
            int n1 = n / i ;
            n = (n -n1);
            i--;
            num = num * n1;
        }
        int n1 = n / i;
        for (int j = 0; j < i; j++) {
            num = num * n1;
        }
        return num;
    }

}
