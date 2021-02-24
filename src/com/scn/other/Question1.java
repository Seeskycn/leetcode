package com.scn.other;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-28
 */
public class Question1 {

    public static void main(String[] args) {
        System.out.println(getResult(1, 52));
    }
    public static int getResult(int num1,int num2){
        int res = 1;
        int i= 2;
        while (true){
            if(i > num1 || i > num2){
                break;
            }
            if(num1%i == 0 && num2 % i == 0){
                num1 = num1/i;
                num2 = num2/i;
                res *= i;
                continue;
            }
            i++;

        }
        return res;


    }
}
