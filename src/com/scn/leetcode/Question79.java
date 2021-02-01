package com.scn.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-01-29
 */
public class Question79 {

    public static void main(String[] args) {
        System.out.println(exist(new char[][]{new char[]{'A', 'B', 'C', 'E'}, new char[]{'S', 'F', 'C', 'S'}, new char[]{'A', 'D', 'E', 'E'}}, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        Map<Character, List<String>> cacheMap = new HashMap<>(52);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                List<String> list = cacheMap.get(board[i][j]);
                if (list == null) {
                    list = new ArrayList<>();
                    cacheMap.put(board[i][j],list);
                }
                list.add(i+"_"+j);
            }
        }

        return isExist(word,cacheMap,new HashSet<String>(),0, "");

    }

    private static boolean isExist(String word, Map<Character, List<String>> cacheMap, HashSet<String> set, int i, String nowStr) {
        if(i == word.length()){
            return true;
        }
        char c = word.charAt(i);
        List<String> list = cacheMap.get(c);
        if (list == null) {
            return false;
        }
        set.add(nowStr);
        for (String str : list) {
            if(set.contains(str)){
                continue;
            }
            if(isLink(nowStr,str)){
                set.add(str);
                i++;
                if(isExist(word,cacheMap,set,i,str)){
                    return true;
                }
                i--;
                set.remove(str);
            }
        }


        return false;
    }

    private static boolean isLink(String str, String nextString) {
        if(str == ""){
            return true;
        }
        String[] str1 = str.split("_");
        String[] str2 = nextString.split("_");
        if((Math.abs(Integer.valueOf(str1[1])-Integer.valueOf(str2[1])) == 1 && Math.abs(Integer.valueOf(str1[0])-Integer.valueOf(str2[0])) == 0)
        || (Math.abs(Integer.valueOf(str1[1])-Integer.valueOf(str2[1])) == 0 && Math.abs(Integer.valueOf(str1[0])-Integer.valueOf(str2[0])) == 1)
        ){
            return true;
        }
        return false;
    }
}
