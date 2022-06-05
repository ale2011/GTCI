/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mcash.gtci.practice.slidingwindow;


/**
 *
 * @author u
 */
public class MaxSumSubArray {
    
    public static int findMaxSumSubArray(int k, int[] arr) {
    int windowSum = 0;  // sum of sliding window
    int maxSum = 0; // max sum
    int windowStart = 0;    // startvalue
    
    // loop through all values
    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
        windowSum += arr[windowEnd]; // add the next element
        // slide the window, we don't need to slide if we've not hit the required window size of 'k'
        if (windowEnd >= k - 1) {
            maxSum = Math.max(maxSum, windowSum);
            windowSum -= arr[windowStart]; // subtract the element going out
            windowStart++; // slide the window ahead
        }
    }
    return maxSum;
    }
    
    public static void main (String [] args) {
        int arr [] = {2,1,5,2,3,2};
        System.out.println(findMaxSumSubArray(3, arr));
    }
}
