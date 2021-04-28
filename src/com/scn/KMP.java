package com.scn;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-12
 */
public class KMP {

    public static void main(String[] args) {
        System.out.println(exist("easdcabcabc", "abc"));
    }

    public static boolean exist(String str1, String str2) {
        int index1 = 0;
        int index2 = 0;
        int[] next = getNext(str2);
        while (index1 < str1.length() && index2 < str2.length()) {
            if (str1.charAt(index1) == str2.charAt(index2)) {
                index1++;
                index2++;
            } else {
                if (next[index2] == -1) {
                    index1++;
                } else {
                    index2 = next[index2];
                }
            }

        }
        return index2 == str2.length() ? true : false;
    }

    private static int[] getNext(String str) {
        int[] next = new int[str.length()];
        int len;
        next[0] = -1;
        for (int i = 1; i < str.length(); i++) {
            len = next[i - 1];
            while (true) {
                if (len == -1) {
                    next[i] = 0;
                    break;
                } else {
                    if (str.charAt(len) == str.charAt(i)) {
                        next[i] = len + 1;
                        break;
                    } else {
                        if (len - 1 < 0) {
                            next[i] = 0;
                            break;
                        }
                        len = next[len - 1];
                    }
                }

            }
        }

        return next;
    }
}
