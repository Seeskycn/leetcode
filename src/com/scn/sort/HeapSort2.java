package com.scn.sort;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-04-26
 */
public class HeapSort2 {

    public static void main(String[] args) {
        int[] heap = {3, 21, 4, 5};
        for (int i = 0; i < heap.length; i++) {
            heapInsert(heap, i);
        }

        int heapSize = heap.length;

        SortUtils.swap(heap, 0, --heapSize);
        while (heapSize > 0) {
            heapIfy(heap, 0, heapSize);
            SortUtils.swap(heap, 0, --heapSize);
        }

       SortUtils.print(heap);

    }

    private static void heapIfy(int[] heap, int index, int heapSize) {
        int leftIndex = index * 2 + 1;
        while (leftIndex < heapSize) {
            int largest = leftIndex + 1 < heapSize ?
                    heap[leftIndex] > heap[leftIndex + 1] ? leftIndex : leftIndex + 1 :
                    leftIndex;
            largest = heap[largest] > heap[index] ? largest : index;
            if (largest == index) {
                break;
            }
            SortUtils.swap(heap, index, largest);
            index = largest;
            leftIndex = largest * 2 + 1;

        }
    }

    private static void heapInsert(int[] heap, int index) {
        while (heap[index] > heap[(index - 1) / 2]) {
            SortUtils.swap(heap, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }
}
