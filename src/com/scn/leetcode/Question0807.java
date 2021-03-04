package com.scn.leetcode;

import javax.lang.model.element.VariableElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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
 * @Date: 2021/3/4 19:29
 * @Description:
 */
public class Question0807 {


    public static void main(String[] args) {
        for (String str : permutation("qwe")) {
            System.out.print(str + " ");
        }
    }

    public static String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        if(S == null ){
            return null;
        }
        backtracking(S.toCharArray(),res,new LinkedList());
        return res.toArray(new String[0]);
    }

    private static void backtracking(char[] toCharArray, List<String> res,LinkedList<Character> path) {

        if(path.size() == toCharArray.length){
            StringBuilder sb = new StringBuilder();
            for (Character character : path) {
                sb.append(character);
            }
            res.add(sb.toString());
            return;
        }
        for (char c : toCharArray) {
            if(path.contains(c)){
                continue;
            }
            path.addLast(c);
            backtracking(toCharArray, res, path);
            path.removeLast();
        }
    }



}
