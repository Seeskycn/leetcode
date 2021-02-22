package com.scn.sort;

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
 * @Date: 2021/2/22 22:26
 * @Description:
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 3, 2, 6, 8};
        sort(ints);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    private static void sort(int[] ints) {

        if (ints == null || ints.length < 2) {
            return;
        }

        // 生成大根堆
        for (int i = 0; i < ints.length; i++) {
            heapInsert(ints,i);
        }

        int heapSize = ints.length;
        swap(ints, 0, --heapSize);
        while (heapSize > 0){
            heapify(ints,0,heapSize);
            swap(ints, 0, --heapSize);

        }


    }

    /**
     * 堆顶下沉
     * @param ints
     * @param index 下沉位置
     * @param heapSize 堆边界
     */
    private static void heapify(int[] ints, int index,int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize &&  ints[left + 1] > ints[left] ?
                    left + 1 : left;
            largest = ints[largest] > ints[index] ? largest : index;
            if(largest == index){
                break;
            }
            swap(ints, index, largest);
            index = largest;
            left = index * 2 + 1;

        }
    }

    /**
     * 堆中插入元素
     * @param ints
     * @param index
     */
    private static void heapInsert(int[] ints, int index) {
        while (ints[index] > ints[(index-1)/2]){
            swap(ints, index, (index-1)/2);
            index = (index-1)/2;
        }


    }

    private static void swap(int[] ints, int i, int j) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
