package com.scn.leetcode;

import jdk.nashorn.internal.ir.IfNode;

import java.util.Scanner;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-07-08
 */
public class Question8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String srt = sc.nextLine();
        System.out.println(myAtoi(srt));
    }

    public static int myAtoi(String str) {
        if(str == null ){
            return 0;
        }
        String trim = str.trim();
        if(trim == null || "".equals(trim)){
            return 0;
        }
        char c = trim.charAt(0);
        if(c!='-' && c!='+' && !(c>='0' && c<='9')){
            return 0;
        }
        //
        int last = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        if ('-'==trim.charAt(last)||'+'==trim.charAt(last)){
            flag2 = true;
            last++;

        }
        if(flag2&&'-'==trim.charAt(last-1)){
            flag1 = true;
        }
        trim = flag2 ? trim.substring(last) : trim;
        int lastNum = 0;
        while (lastNum < trim.length()){
            c = trim.charAt(lastNum);

            if(!(c>='0' && c<='9')){
                break;
            }
            lastNum ++;

        }
        trim = lastNum == trim.length() ? trim : trim.substring(0,lastNum);
        while (trim.startsWith("0")&& trim.length()>1){
            trim = trim.substring(1);
        }
        if(trim.length()>0){
            if(trim.length()>(Integer.MAX_VALUE+"").length()){
                return flag1?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            Long result = Long.valueOf(trim);
            return flag1 ?
                    (result * -1 <Integer.MIN_VALUE ? Integer.MIN_VALUE :result.intValue()*-1):
                    (result>Integer.MAX_VALUE ? Integer.MAX_VALUE:result.intValue());
        }
        return 0;

    }
}
