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
 * @Date: 2021/2/24 22:34
 * @Description:
 */
public class Question309 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        // op 1 代表可用买 0 ,代表不能买
        return getResult(prices, 0, 1,0,Integer.MIN_VALUE);
    }

    private static int getResult(int[] prices, int day, int op,int sum,int pri) {

        if (day < prices.length) {
            if (op == 1) {

                sum = Math.max(
                        // 今天不买
                        getResult(prices, day + 1, 1,sum,pri),
                        // 今天买
                        getResult(prices, day + 1, 0,sum,prices[day]));

            } else {

                sum = Math.max(
                        // 今天卖
                        getResult(prices, day + 2, 1,sum+prices[day] - pri,Integer.MIN_VALUE),
                        // 今天不卖
                        getResult(prices, day+1, 0,sum,pri)
                );

            }

        }
        return sum;



    }
}
