package com.learn;

import java.util.Arrays;

public class RunningSum1DArray {
    public static int[] runningSum(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        int[] sumArr = new int[nums.length];
        sumArr[0] = nums[0];

        for(int i=1, j=1; i<nums.length; i++, j++ ){
            sumArr[j] = sumArr[j-1] + nums[i];
        }
        return sumArr;
    }

    public static void main(String[] args) {
        Arrays.stream(runningSum(new int[]{1, 2, 3, 4})).forEach(System.out::println);
    }
}
