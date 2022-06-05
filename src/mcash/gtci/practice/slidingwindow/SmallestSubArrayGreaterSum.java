/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcash.gtci.practice.slidingwindow;

/**
 *  
 * @author u
 */
public class SmallestSubArrayGreaterSum {
    
    /**
     * 
     * @param s
     * @param arr
     * @return 
     */
    public static int findMinSubArray(int s, int[] arr) {
        int smallestLength = Integer.MAX_VALUE;
        int windowSum = 0;
        int start = 0;
        
        for(int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            
            while(windowSum >= s) {
                smallestLength = Math.min(smallestLength, end-start+1);
                windowSum -= arr[start];
                start++;
            }
        }
        
        if(smallestLength == Integer.MAX_VALUE)
            return 0;
        else
            return smallestLength;
  }
    
    public static void main (String [] args) {
        int arr [] = {2,1,5,2,3,2};
        System.out.println(findMinSubArray(7, arr));
    }
}
