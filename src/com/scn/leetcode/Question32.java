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
 * @Date: 2021/1/11 22:29
 * @Description:
 */
public class Question32 {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(()"));
    }
    public static int longestValidParentheses(String s) {
        int begin = 0;
        int end = 0;
        String now = "";
        int leftCount = 0;
        int rightCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if ('(' == s.charAt(i)) {
                if(leftCount == 0){
                    begin = i;
                }
                leftCount++;
            }else{
                if(leftCount == 0){
                    continue;
                }else {
                    if(rightCount < leftCount){
                        rightCount++;
                    }else {
                        end = i;
                        now = now.length()>(end-begin+1)?now:s.substring(begin,end);
                        begin = i;
                        leftCount = 0;
                        rightCount = 0;
                    }
                }
            }

        }

        System.out.println(now);
        return now.length() > rightCount*2? now.length() : rightCount*2;

    }
}
