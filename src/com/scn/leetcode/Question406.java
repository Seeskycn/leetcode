package com.scn.leetcode;

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
 * @Date: 2021/3/1 21:36
 * @Description:
 */
public class Question406 {

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};

        for (int[] ints : reconstructQueue(people)) {
            System.out.print("["+ ints[0] + "," + ints[1]+"] ");
        }
    }
    public static int[][] reconstructQueue(int[][] people) {
        for (int i = 0; i < people.length; i++) {
            heapInsert(people,i);
        }

        int index = people.length-1;

        for (int[] ints :people) {
            System.out.print("["+ ints[0] + "," + ints[1]+"] ");
        }
        System.out.println();
        swap(people, 0, people.length-1);
        while (index > 0){
            heapify(people,0,index);
            swap(people, 0, --index);
        }


        for (int i = people.length - 1; i >=0 ; i--) {

        }
        return people;
    }

    private static void heapify(int[][] people, int index, int limit) {
        int left = index * 2 + 1;
        while (left < limit){
            int largest = left + 1 < limit ?
                    ( people[left][0] > people[left + 1][0] ||
                            (people[left][0] == people[left + 1][0] && people[left][1] < people[left + 1][1] ) ? left : left+1 )

            : left;
            largest = ( people[largest][0] > people[index][0] ||
                    (people[largest][0] == people[index ][0] && people[largest][1] < people[index][1] )) ? largest : index;
            if(largest == index){
                break;
            }

            swap(people, largest, index);
            index = largest;
            left = index * 2 + 1;

        }
    }

    private static void heapInsert(int[][] people, int i) {
        int parentIndex = (i-1)/2;
        while (people[i][0] > people[parentIndex][0] || (people[i][0] == people[parentIndex][0] && people[i][1] < people[parentIndex][1] )){

            swap(people,i,parentIndex);
            i = (i-1)/2;
            parentIndex = (i-1)/2;
        }
    }

    private static void swap(int[][] people, int i, int parentIndex) {
        int[] temp = people[i];
        people[i] = people[parentIndex];
        people[parentIndex] = temp;
    }


}
