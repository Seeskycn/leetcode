package com.scn.book.part5;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-05-07
 */
public class Question10 {

    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }

        char[] res = new char[26];
        int index = 0;
        int L = 0;
        int R = 0;
        while (R != chars.length) {
            // 如果当前字符串是不考虑的,直接跳过
            // 如果单前字符出现的次数减 1之后还能继续出现,直接跳过
            if (map[chars[R] - 'a'] == -1 || --map[chars[R] - 'a'] > 0) {
                R++;
            } else {
                // 当前字符需要考虑并且之后不会在出现
                // 在chars[L...R] 上所有需要考虑的字符串中,找到 ascii 码最小的字符串
                int pick = -1;
                for (int i = L; i < R; i++) {
                    if (map[chars[i] - 'a'] != -1 && (pick == -1 || chars[i] < chars[pick])) {
                        pick = i;
                    }
                }
                // 把 ascii 码最小的字符串放到结果中
                res[index++] = chars[pick];
                // 上一个for 循环中,chars[L ... R] 范围内的每种字符串出现的次数都减少了
                // 需要把 chars[pick+1 ... R] 上每种字符串出现的次数加回来
                for (int i = pick + 1; i < R; i++) {
                    if (map[chars[i] - 'a'] != -1) {
                        map[chars[i] - 'a']++;
                    }
                }
                // 选出的字符,以后不再考虑
                map[chars[pick]-'a'] = -1;
                // 继续在 str[pick+1 ... R] 上重复
                L = pick +1;
                R = L;
            }
        }

        return new String(res);
    }

}
