package com.learn.contests.week_310;


import java.util.HashMap;
import java.util.Map;

/*Given an integer array nums, return the most frequent even element.

If there is a tie, return the smallest one. If there is no such element, return -1.



Example 1:

Input: nums = [0,1,2,2,4,4,1]
Output: 2
Explanation:
The even elements are 0, 2, and 4. Of these, 2 and 4 appear the most.
We return the smallest one, which is 2.
Example 2:

Input: nums = [4,4,4,9,2,4]
Output: 4
Explanation: 4 is the even element appears the most.
Example 3:

Input: nums = [29,47,21,41,13,37,25,7]
Output: -1
Explanation: There is no even element.


Constraints:

1 <= nums.length <= 2000
0 <= nums[i] <= 105
*/

public class MostFrequentEvenElement_2404 {
    public int mostFrequentEven(int[] nums) {
        int smallest = -1;
        int maxCounter = 0;

        Map<Integer, Integer> counterMap = new HashMap<>();

        for (int key : nums) {
            if (key % 2 == 0) {
                counterMap.computeIfPresent(key, (k, v) -> v + 1);
                counterMap.putIfAbsent(key, 1);
                if (smallest == -1) {
                    smallest = key;
                } else if (maxCounter < counterMap.get(key)) {
                    smallest = key;
                    maxCounter = counterMap.get(key);
                } else if (maxCounter == counterMap.get(key) && smallest > key) {
                    smallest = key;
                }
            }
        }

        return smallest;

    }

    public static void main(String[] args) {
        MostFrequentEvenElement_2404 even = new MostFrequentEvenElement_2404();
        System.out.println(even.mostFrequentEven(new int[]{ 0,1,2,2,4,4,1}));
        System.out.println(even.mostFrequentEven(new int[]{ 3,1,1}));
        System.out.println(even.mostFrequentEven(new int[]{ 0,1,2,2,4,4,4,1}));
        System.out.println(even.mostFrequentEven(new int[]{ 0,0,0,1,2,2,4,4,1,}));
    }
}