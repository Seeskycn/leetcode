package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] ints = new int[]{1,5,4,2,3,7,9,10,2,4,5,1};
        sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void sort(int[] ints) {
        if (ints == null && ints.length < 2) {
            return;
        }

        // 生成大根堆
        for (int i = 0; i < ints.length; i++) {
            heapInsert(ints,i);
        }


        int heapSize = ints.length;
        // 大根放到最后
        SortUtils.swap(ints,0,--heapSize);
        while (heapSize >0){
            // 根节点下沉
            heapify(ints,0,heapSize);
            // 下一个位置
            SortUtils.swap(ints,0,--heapSize);
        }

    }

    private static void heapify(int[] ints, int index, int heapSize) {
        // index 节点的左孩子节点
        int left = index * 2 + 1 ;
        while (left < heapSize){
            // 左右孩子节点比较,右节点不超过限制,并且和左孩子进行比较
            int largest = left + 1 < heapSize && ints[left + 1] > ints[left]
                    ? left + 1 : left;
            largest = ints[largest] > ints[index] ? largest : index;
            // 当前节点大于所有孩子节点
            if(largest == index){
                break;
            }
            // 下沉
            SortUtils.swap(ints,index,largest);
            index = largest;
            left = largest * 2 + 1;

        }
    }

    private static void heapInsert(int[] ints, int index) {
        while (ints[index] > ints[(index -1)/2]){
            SortUtils.swap(ints,index,(index-1)/2);
            index = (index -1) / 2;
        }
    }
}
