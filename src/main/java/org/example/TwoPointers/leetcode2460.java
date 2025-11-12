package org.example.TwoPointers;

import java.util.Arrays;

public class leetcode2460 {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;

        // Step 1: Apply operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;       // double current number
                nums[i + 1] = 0;    // set next number to zero
            }
        }

        // Step 2: Move non-zero numbers to front
        int nonZeroIdx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIdx++] = nums[i];
            }
        }

        // Step 3: Fill remaining positions with zeros
        while (nonZeroIdx < n) {
            nums[nonZeroIdx++] = 0;
        }

        return nums;
    }

    // Main method to test locally in IntelliJ
    public static void main(String[] args) {
        leetcode2460 sol = new leetcode2460();

        int[] nums = {1, 2, 2, 1, 1, 0};
        int[] result = sol.applyOperations(nums);

        System.out.println("Output: " + Arrays.toString(result));
    }
}

