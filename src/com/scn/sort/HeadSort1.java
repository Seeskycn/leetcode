package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-23
 */
public class HeadSort1 {

    public static void main(String[] args) {
        int[] ints = new int[]{1, 5, 4, 2, 3, 7, 9, 10, 2, 4, 5, 1};
        sort(ints);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }

    private static void sort(int[] ints) {
        if (ints == null || ints.length < 2) {
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            heapInsert(ints, i);
        }
        int heapSize = ints.length;
        SortUtils.swap(ints, 0, --heapSize);
        while (heapSize > 0) {
            heapify(ints, 0, heapSize);
            SortUtils.swap(ints, 0, --heapSize);
        }
    }

    /**
     * index 位置下沉
     *
     * @param ints
     * @param index
     * @param heapSize
     */
    private static void heapify(int[] ints, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && ints[left + 1] > ints[left]
                    ? left + 1 : left;
            largest = ints[index] > ints[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            SortUtils.swap(ints, index, largest);
            index = largest;
            left = largest * 2 + 1;

        }
    }

    /**
     * 生成大根堆
     *
     * @param ints
     * @param i
     */
    private static void heapInsert(int[] ints, int i) {
        while (ints[i] > ints[(i - 1) / 2]) {
            SortUtils.swap(ints, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }
}
