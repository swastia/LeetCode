package com.learn.contests.week_310;
/*Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.



Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.
Example 2:

Input: s = "ssssss"
Output: 6
Explanation:
The only valid partition is ("s","s","s","s","s","s").*/


import java.util.HashMap;
import java.util.Map;

public class OptimalPartitionOfString_2450 {


    /** This is my appraoch, where I am forming sub-strings from input string.
     * This returns the minimum possible substrings where the characters are not repeated
     * this is though a bit deviated from original question, where we have partition the string from left to right.
     * **/
    public int uniqueSubStrings(String s) {
        int minCounter = 0;
        Map<Character, Integer> charCountMap = new HashMap<>();

        if (s == null || s.isBlank()) {
            return minCounter;
        }

        // create a hashmap of char - counter
        for (char c : s.toCharArray()) {
            charCountMap.computeIfPresent(c, (k, v) -> v + 1);
            charCountMap.putIfAbsent(c, 1);
        }

        while (!charCountMap.isEmpty()) {
            charCountMap.entrySet().removeIf(entry -> entry.getValue() == 0);
            charCountMap.entrySet().forEach(charIntEntry -> charIntEntry.setValue(charIntEntry.getValue() - 1));
            minCounter++;
        }
        return minCounter - 1;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString_2450 part = new OptimalPartitionOfString_2450();
        System.out.println(part.uniqueSubStrings("aaabbbccc"));
        System.out.println(part.uniqueSubStrings("  "));
        System.out.println(part.uniqueSubStrings("abacaba"));
        System.out.println(part.uniqueSubStrings("sssssss"));
        System.out.println(part.uniqueSubStrings("hdklqkcssgxlvehva"));


//        System.out.println(part.partitionString("aaabbbccc"));
//        System.out.println(part.partitionString("  "));
//        System.out.println(part.partitionString("abacaba"));
//        System.out.println(part.partitionString("sssssss"));
//        System.out.println(part.partitionString("hdklqkcssgxlvehva"));
    }


//    public int partitionString(String s){
//        int minCounter = 0;
//        Map<Character, Integer> map = new HashMap<>();
//
//        for (char c: s.toCharArray()) {
//
//            map.entrySet().forEach(entry ->{
//                if(entry.getValue() == 1)
//                    map.clear();
//            } );
//            map.putIfAbsent(c,1);
//            minCounter++;
//        }
//
//        return minCounter -1;
//    }
}
