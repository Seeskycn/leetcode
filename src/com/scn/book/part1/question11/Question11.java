package com.scn.book.part1.question11;

import java.util.Stack;

/**
 * @author chaonan shan
 * @description： TODO
 * @since 2020-08-14
 */
public class Question11 {
    public static void main(String[] args) {

    }
    public static int getVisibleCount(int[] arrays){

        if (arrays == null || arrays.length == 0) {
            return 0;
        }
        int size = arrays.length;
        int maxIndex = 0;

        for (int i = 0; i < size; i++) {
            maxIndex = arrays[maxIndex] < arrays[i] ? i : maxIndex ;
        }
        Stack<Record> stack = new Stack<>();
        // 先把最大值放入栈中
        stack.push(new Record(maxIndex));

        //从最大值的下一个位置开始沿next方向遍历数据
        int index = nextIndex(maxIndex,size);

        // 用 小找大的方式统计所有可见山峰对
        int res = 0;

        // 遍历阶段, index 再次回到 maxIndex 的时候，说明转了一圈，遍历阶段就结束
        while (index != maxIndex){
            // 当前数字 arr[index]要进栈，判断会不会破坏第一维的数字从顶到底依次变大
            // 如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
            while (stack.peek().value < arrays[index] ){
                int k = stack.pop().time;
                // 弹出记录为(X,K)，如果 K==1，产生 2 对
                // 如果 K>1，产生 2*K + C(2,K)对
                res += getInternalSum(k) + 2 * k;
            }
            // 当前数字 arr[index]要进入栈了，如果和当前栈顶数字一样就合并
            // 不一样就把记录(arr[index],1)放入栈中
            if(arrays[index] == stack.peek().value){
                stack.peek().time++;
            }else{
                stack.push(new Record(arrays[index]));
            }
            index = nextIndex(index,size);
        }
        // 清算阶段
        // 第一阶段
        while (stack.size() > 2){
            int time = stack.pop().time;
            res += getInternalSum(time) + 2 * time;
        }

        // 第二阶段
        if(stack.size() == 2){
            int time = stack.pop().time;
            res += getInternalSum(time) + ( stack.peek().time == 1 ? time : 2* time);
        }

        //第三阶段
        res += getInternalSum(stack.pop().time);
        return res;

    }

    private static int getInternalSum(int k) {
        return k == 1 ? 0 : (k * (k-1)/2);
    }

    private static int nextIndex(int maxIndex, int size) {
        return maxIndex< size -1 ? (maxIndex + 1) : 0;
    }



}
class Record{
    public int value;
    public int time;

    public Record(int value) {
        this.value = value;
        this.time = 1;
    }
}
