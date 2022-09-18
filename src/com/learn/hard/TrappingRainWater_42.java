package com.learn.hard;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 **/
public class TrappingRainWater_42 {
    /*Following Brute Force approach here
     * to find maximum water at any given point, find the maximum height at it's left and maximum height at it's right
     * The water between those heights minus the current height should give the units of water that can be stored
     * */

    // This solutions will be very slow and is not accepted by LeetCode due to Timeout

    public static int trap(int[] height) {
        int maxWater = 0;
        int current = 0;


        while (current < height.length - 1) {
            int maxL = 0;
            int maxR = 0;

            // find max right
            for (int i = current + 1; i < height.length; i++) {
                maxR = Math.max(maxR, height[i]);
            }
            //find max left
            for (int j = current - 1; j >= 0; j--) {
                maxL = Math.max(maxL, height[j]);
            }

            maxWater = Math.max(maxWater, (maxWater + (Math.min(maxL, maxR) - height[current])));
            current++;
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{4, 2, 0, 3, 2, 5}));

        System.out.println(trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap2(new int[]{4, 2, 0, 3, 2, 5}));
    }


    /**
     * Below is an optimal solution using two poiters technique, to improve the time complexity from O(n^2) to linear time.
     * Things we need to keep in mind:
     * 1.
     **/
    public static int trap2(int[] height) {
        int totalWater = 0;
        int left = 0;
        int right = height.length - 1;
        int maxL = 0, maxR = 0;
        // if height at left pointer is >= max height on left, the no water can stay
        while (left < right) {
            if (height[left] <= height[right]) {
                if (height[left] < maxL) {
                    totalWater = totalWater + maxL - height[left];
                    left++;
                } else {
                    maxL = height[left];
                    left++;
                }
            } else {
                if (height[right] < maxR) {
                    totalWater = totalWater + maxR - height[right];
                    right--;
                } else {
                    maxR = height[right];
                    right--;
                }
            }
        }
        return totalWater;
    }
}
