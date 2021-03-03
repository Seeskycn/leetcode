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
 * @Date: 2021/3/2 22:31
 * @Description:
 */
public class Offer03 {

    public static void main(String[] args) {
        int[] ints = {0, 1, 2, 3, 4, 11, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        System.out.println(findRepeatNumber(ints));
    }

    public static int findRepeatNumber2(int[] nums) {
        int[] index = new int[nums.length];

        for (int num : nums) {
            if(index[num] == 1){
                return num;
            }else {
                index[num] = 1;
            }
        }
        return -1;

    }
    public static int findRepeatNumber(int[] nums) {

        return getResult(nums, 0, nums.length - 1);
    }

    private static int getResult(int[] nums, int begin, int end) {
        int num = nums[Math.round(end-begin)];
        int[] res = partion(nums, begin, end, num);
        while (true){
            if(res[0] != res[1]){
                return num;
            }else {
                if(res[0] >= num){
                    end = res[0]-1;
                }else if(res[1] <= num){
                    begin = res[1]+1;
                }
                num = nums[Math.round(end-begin)];
                res = partion(nums, begin, end, num);
            }
        }

    }

    private static int[] partion(int[] nums, int begin, int end, int num) {

        int less = begin - 1;
        int more = end + 1;
        int index = begin;
        while (index < more) {
            if (nums[index] < num) {
                swap(nums, index++, ++less);
            }else if (nums[index] > num){
                swap(nums, index,--more);
            }else {
                index++;
            }
        }


        return new int[]{less+1,more-1};
    }

    private static void swap(int[] arr , int i ,int j){

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }


}
