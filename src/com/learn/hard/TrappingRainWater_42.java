package com.learn.hard;

/**Given n non-negative integers representing an elevation map where the width of each bar is 1,
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


        while (current<height.length -1){
            int maxL = 0;
            int maxR = 0;

            // find max right
            for(int i = current+1; i< height.length; i++){
                maxR = Math.max(maxR, height[i]);
            }
            //find max left
            for(int j = current-1; j>=0; j--){
                maxL = Math.max(maxL, height[j]);
            }

            maxWater = Math.max(maxWater, (maxWater + (Math.min(maxL, maxR) - height[current])));
            current++;
        }

        return maxWater;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[] { 0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(trap(new int[] { 4,2,0,3,2,5}));
    }
}
