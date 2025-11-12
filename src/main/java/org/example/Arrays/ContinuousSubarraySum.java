package org.example.Arrays;


import java.util.HashMap;

public class ContinuousSubarraySum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // base case: remainder 0 before array starts

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int remainder = sum % k;
            if (remainder < 0) { // handle negative numbers
                remainder += k;
            }

            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                // check length >= 2
                if (i - prevIndex > 1) {
                    return true;
                }
            } else {
                // store the first index of this remainder
                map.put(remainder, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k)); // Output: true
    }
}
