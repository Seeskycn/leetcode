package com.scn.datastructure.array;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2021-03-11
 */
public class Question136 {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
    }

    public static int singleNumber(int[] nums) {

        int start = 0;
        int end = nums.length-1;
        while (true){
            int[] res = partion(nums,start,end);
            if(res[0] == 1){
                return nums[0];
            }
            if(nums.length-res[1]-1 == 1){
                return nums[nums.length-1];
            }
            if((res[0])%2 != 0){
                end = res[0]-1;
            }else if((nums.length-res[1]-1)%2 != 0){
                start = res[1]+1;
            }else {
                return nums[res[0]];
            }
        }

    }

    private static int[] partion(int[] nums, int L, int R) {
        int less = L-1;
        int more = R+1;
        int num = nums[R];
        int i = L;
        while (i < more) {
            if(nums[i] < num){
                swap(nums,++less,i++);
            }else if (nums[i]>num){
                swap(nums,--more,i);
            }else {
                i++;
            }
        }
        return new int[]{less+1,more-1};

    }
    public static void swap(int[] nums , int i ,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
