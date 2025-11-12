package org.example.Arrays;

import java.util.HashMap;
import java.util.Map;

public class MinimumIndexOfAValidSplit {
    public int minimumIndex(int[] nums) {
        int n = nums.length;

        // Step 1: find the dominant element of the entire array
        Map<Integer, Integer> freq = new HashMap<>();
        int dominant = nums[0], dominantCount = 0;
        for (int v : nums) {
            freq.put(v, freq.getOrDefault(v, 0) + 1);
            if (freq.get(v) > dominantCount) {
                dominant = v;
                dominantCount = freq.get(v);
            }
        }

        // Step 2: iterate through potential split points, counting how many times
        // the dominant appears in left part so far.
        int leftCount = 0;
        for (int i = 0; i < n - 1; i++) {  // i goes to n-2 at most
            if (nums[i] == dominant) {
                leftCount++;
            }
            int sizeLeft = i + 1;
            int sizeRight = n - sizeLeft;
            int rightCount = dominantCount - leftCount;

            // Check if dominant is dominant in both parts:
            // leftCount * 2 > sizeLeft  AND  rightCount * 2 > sizeRight
            if (leftCount * 2 > sizeLeft && rightCount * 2 > sizeRight) {
                return i;
            }
        }

        // If we never found a valid split
        return -1;
    }

    public static void main(String[] args) {
        MinimumIndexOfAValidSplit sol = new MinimumIndexOfAValidSplit();
        System.out.println(sol.minimumIndex(new int[]{1,2,2,2}));  // prints 2
        System.out.println(sol.minimumIndex(new int[]{2,1,3,1,1,1,7,1,2,1}));  // example from problem
        System.out.println(sol.minimumIndex(new int[]{3,3,3,3,7,2,2}));  // prints -1
    }
}

