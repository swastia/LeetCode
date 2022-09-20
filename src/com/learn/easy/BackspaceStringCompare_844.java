package com.learn.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.



Example 1:

Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both s and t become "ac".
*/
public class BackspaceStringCompare_844 {

    // Brute Force,  we can also use stack for pushing and popping characters
    public static boolean backspaceCompare(String s, String t) {
        List<Character> s1 = getResult(s), t1 = getResult(t);
        if(s1.size() != t1.size()){
            return false;
        }

        String rs1 = s1.stream().map(String::valueOf).collect(Collectors.joining());
        String rt1 = t1.stream().map(String::valueOf).collect(Collectors.joining());

        return rs1.equals(rt1);
    }

    private static List<Character> getResult(String str){
        List<Character> result = new ArrayList<>();

        for(int i=0; i<str.toCharArray().length; i++){
            if(str.charAt(i) == '#'){
                // when list is empty, do nothing
                if(result.size() == 0){
                    continue;
                }else{
                    result.remove(result.size()-1);
                }
            } else{
                result.add(str.charAt(i));
            }
        }

    return result;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("a#b#c#", "a#d#c#"));
        System.out.println(backspaceCompare("a###c", "a#d#c"));
        System.out.println(backspaceCompare("a#b#c", "ad#c"));

        System.out.println(backspaceCompareOptimized("ab#c", "ad#c"));
        System.out.println(backspaceCompareOptimized("a#b#c#", "a#d#c#"));
        System.out.println(backspaceCompareOptimized("a###c", "a#d#c"));
        System.out.println(backspaceCompareOptimized("a#b#c", "ad#c"));

    }

    // Below is an optimal solution
    //TODO: To fix

    public static boolean backspaceCompareOptimized(String s, String t) {
        int ps = s.length() - 1, pt = t.length() -1;

        while(ps >= 0 || pt >= 0){
            if(s.charAt(ps) == '#' || t.charAt(pt) == '#'){
                //check if char at current index is #
                if(s.charAt(ps) == '#'){
                    int sCount=2;
                    while(sCount>0 && ps > 0){
                        ps--;
                        sCount--;
                        if(s.charAt(ps) == '#'){
                            sCount += 2;
                        }
                    }
                }
                if(t.charAt(pt) == '#'){
                    int tCount =2;
                    while(tCount>0 && pt>0){
                        pt--;
                        tCount--;
                        if(t.charAt(pt) == '#'){
                            tCount += 2;
                        }
                    }
                }
            }

            if(s.charAt(ps) != '#' && t.charAt(pt) != '#'){
                if(s.charAt(ps) != t.charAt(pt)) {
                    return false;
                }
                else{
                    ps--;
                    pt--;
                }
            }
        }
        return true;
    }
}
