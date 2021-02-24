package com.scn.leetcode;

/**
 * @author chaonan shan
 * @description： 数组中第k大的数
 * @since 2021-02-23
 */
public class Question215 {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums,9));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 1){
            return nums[0];
        }
        return findKthLargest(nums,0,nums.length-1,k);
    }

    private static int findKthLargest(int[] nums, int begin, int end, int k) {
        k = nums.length-k;

        while (true){
            swap(nums,begin+Math.round(end-begin),end);
            int[] res = partion(nums, begin, end);
            int less = res[0];
            int more = res[1];

            if (less == k || more == k) {
                return nums[k];
            }
            if(less - 1>= k){
                end = less -1;
            }else if (more + 1 <= k){
                begin = more + 1;
            }else {
                return nums[less];
            }
        }
    }

    /**
     * 返回值
     * @param nums 0 位置为小于最后一个数的
     * @param L
     * @param R
     * @return
     */
    private static int[] partion(int[] nums, int L, int R) {
        int less = L - 1;
        int more = R;
        int cur = L;
        while (cur < more) {
            if (nums[cur] < nums[R]) {
                swap(nums, cur++, ++less);
            } else if (nums[cur] > nums[R]) {
                swap(nums, cur, --more);
            } else {
                cur++;
            }
        }
        swap(nums,more,R);
        return new int[]{less + 1,more};
    }

    private static void heapInsert(int[] nums, int i) {
        while (nums[i] > nums[(i-1)/2]){
            swap(nums,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
