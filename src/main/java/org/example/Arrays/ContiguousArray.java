package org.example.Arrays;

import java.util.HashMap;

public class ContiguousArray {
    public static int findMaxLength(int[] nums) {
        // Map to store (sum → first index where sum appeared)
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // Base case: sum 0 before array starts

        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            // Convert 0 → -1
            if (nums[i] == 0)
                sum -= 1;
            else
                sum += 1;

            // If we saw this sum before → subarray (previousIndex+1 to i) has equal 0s and 1s
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                // Store first time we see this sum
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 1,0,0,1,1};
        System.out.println(findMaxLength(nums)); // Output: 8
    }
}

