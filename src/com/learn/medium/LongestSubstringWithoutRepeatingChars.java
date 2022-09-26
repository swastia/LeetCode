package com.learn.medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingChars {

    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        if(s.isEmpty() || s.isBlank()){
            return longest;
        }

        for(int i=0; i< s.length(); i++){
            Map<Character,Integer> occurrenceMap = new HashMap<>();
            occurrenceMap.putIfAbsent(Character.valueOf(s.charAt(i)), 1);
            int currentLen = 1;

            for(int j=i+1; j<s.length(); j++){
                if(occurrenceMap.containsKey(s.charAt(j)) || (j == s.length() -1)){
                    longest = Math.max(longest, currentLen);
                    occurrenceMap.clear();
                    break;
                } else{
                    currentLen++;
                }
            }
        }

        return longest;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("aaaa"));
        System.out.println(lengthOfLongestSubstring("abababbb"));
        System.out.println(lengthOfLongestSubstring("abcdabcdefg"));
    }
}
