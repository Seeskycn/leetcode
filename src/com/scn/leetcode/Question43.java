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
 * @Date: 2021/1/18 21:57
 * @Description:
 */
public class Question43 {

    public static void main(String[] args) {
        System.out.println(multiply("6", "501"));
    }
    public static String multiply(String num1, String num2) {
        if( "0".equals(num1) || "0".equals(num2)){
            return "0";
        }
        Map<Integer,String> resultMap = new HashMap<>(9);
        for (int i = 1; i <= 9; i++) {
            resultMap.put(i,getResult(num1,i));
        }

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length()-1; i >=0 ; i--) {
            if (num2.charAt(i) == '0') {
                sb.append(0);
                continue;
            }

            result.add( resultMap.get(num2.charAt(i) - '0')+sb.toString());
            sb.append(0);
        }
        String resultStr = "0";
        for (String str : result) {
            resultStr = getSum(resultStr, str);
        }


        return resultStr;
    }

    private static String getResult(String num1, int i) {
        if(i == 1){
            return num1;
        }else {
            String sum = num1;
            for (int j = 0; j < i-1; j++) {
                sum = getSum(sum, num1);
            }
            return sum;
        }

    }
    private static String getSum(String num1,String num2){
        int i = num1.length() -1;
        int j = num2.length() -1;
        StringBuilder sb = new StringBuilder();
        // 进位标志
        int flag = 0;
        while (i>=0 || j >= 0){
            int n1 = i < 0 ? 0:num1.charAt(i)-'0';
            int n2 = j < 0 ? 0:num2.charAt(j)-'0';
            int res =n1+n2+flag;
            if(res >=10){
                flag = res/10;
            }else {
                flag = 0;
            }
            sb.append(res%10);
            i--;
            j--;
        }

        if(flag != 0){
            sb.append(flag);
        }

        return sb.reverse().toString();
    }
}
