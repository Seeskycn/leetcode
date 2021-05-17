package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-13
 */
public class Question520 {

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("Facebook"));
    }
    public static boolean detectCapitalUse(String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        if(word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())){
            return true;
        }else {
            if(word.charAt(0) < 'a'){
                for (int i = 1; i < word.length(); i++) {
                    if(word.charAt(i)<'a'){
                        return false;
                    }
                }
            }else {
                return false;
            }
        }
        return true;
    }
}
