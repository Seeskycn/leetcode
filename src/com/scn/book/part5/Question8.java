package com.scn.book.part5;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-07
 */
public class Question8 {


    public static void rotate1(char[] chars , int size){

        if (chars == null || size < 0 || size > chars.length) {
            return;
        }

        reverse(chars,0,size-1);
        reverse(chars,size,chars.length-1);
        reverse(chars,0,chars.length-1);
    }

    private static void reverse(char[] chars, int begin, int end) {
        while (begin < end){
            char aChar = chars[begin];
            chars[begin] = chars[end];
            chars[end] = aChar;
            begin++;
            end--;
        }
    }
}

