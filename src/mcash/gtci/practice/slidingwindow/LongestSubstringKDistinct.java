/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcash.gtci.practice.slidingwindow;

import java.util.HashMap;

/**
 *
 * @author u
 */
public class LongestSubstringKDistinct {
    public int findLongestDistinctSubstring(String str, int k) {
        if(str == null || str.length() == 0)
            return 0;
        
        int start = 0;
        int maxLength = Integer.MIN_VALUE;
        HashMap <Character, Integer> distinct = new HashMap <> ();
        
        for(int end = 0; end < str.length(); end++) {
            char right = str.charAt(end);
            distinct.put(right, distinct.getOrDefault(right, 0)+1);
            
            while(distinct.size() > k) {
                char left = str.charAt(start);
                distinct.put(left, distinct.getOrDefault(left, 0)-1);
                
                if(distinct.get(left) == 0)
                    distinct.remove(left);
                
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}
