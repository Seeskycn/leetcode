package com.scn.offer;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-02-22
 */
public class Question51 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,3,2,3,1};

        System.out.println(reversePairs(ints));
    }

    public static int reversePairs(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return getCount(nums, 0, nums.length - 1);
    }

    private static int getCount(int[] nums, int L, int R) {
        if (L == R) {
            return 0;
        }
        int mid = (L + R) / 2;

        return getCount(nums, L, mid) + getCount(nums, mid + 1, R) + merge(nums, L, mid, R);
    }

    private static int merge(int[] nums, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int p1 = L;
        int p2 = mid + 1;
        int index = 0;
        int res = 0;
        while (p1 <= mid && p2 <= R) {
            if(nums[p1] < nums[p2]){
                res += p2 - (mid+1);
                temp[index++] = nums[p1++];
            }else {
                temp[index++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            res += R - mid;
            temp[index++] = nums[p1++];
        }
        while (p2 <= R) {
            temp[index++] = nums[p2++];
        }
        // 拷贝回原数组
        for (int i = 0; i < temp.length; i++) {
            nums[L + i] = temp[i];
        }

        return res;
    }
}
