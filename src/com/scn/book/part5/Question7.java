package com.scn.book.part5;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-07
 */
public class Question7 {

    public void replace(char[] chars) {

        if (chars == null || chars.length == 0) {
            return;
        }
        int num = 0;
        int len = 0;
        for (len = 0; len < chars.length && chars[len] != 0; len++) {
            if (chars[len] == ' ') {
                num++;
            }
        }
        int j = len + num * 2 -1;
        for (int i = len - 1; i >-1 ; i--) {
            if (chars[i] != ' ') {
                chars[j--] = chars[i];
            }else {
                chars[j--] = '0';
                chars[j--] = '2';
                chars[j--] = '%';
            }
        }
    }
}
