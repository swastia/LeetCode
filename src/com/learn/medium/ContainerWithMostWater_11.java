package com.learn.medium;

/*You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
*/
public class ContainerWithMostWater_11 {

    /*Using Brute Force - find areas between all lines and return the maximum*/
    /* This solution works but has a timecomplexity of O(n^2), and space compexity of O(1)
    when the input is really huge, it executes slow and LeetCode did not accept this solution.
    Check maxArea2 for a better solution
    * */
    public static int maxArea(int[] height) {
        // area = l*b
        int maxArea = 0;

        for(int i=0; i<height.length -1;i++){
            for(int j = i+1; j< height.length; j++ ){
                int area, l, b;
                l = Math.min(height[i], height[j] );
                b = j-i;
                area = l*b;
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {7,1,2,3,8}));
        System.out.println(maxArea(new int[] {7}));
        System.out.println(maxArea(new int[] {}));

        System.out.println(maxArea2(new int[] {7,1,2,3,8}));
        System.out.println(maxArea2(new int[] {7}));
        System.out.println(maxArea2(new int[] {}));
    }

    /* This is an optimised solution, with time complexity of O(n) and space complexity O(1)
    It uses two pointer approach.
    * */
    public static int maxArea2(int[] height) {
        int maxArea = 0;
        int p1=0, p2 = height.length - 1;
        while(p1< p2){
            int l = Math.min(height[p1], height[p2]);
            int b = p2-p1;
            int area = l*b;
            maxArea = Math.max(maxArea, area);

            if(height[p1] < height[p2]){
                p1++;
            }else{
                p2--;
            }
        }

        return maxArea;
    }
}
