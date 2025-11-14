package org.example.Arrays;

import java.util.HashMap;

public class leetCode2023 {
    public int numOfPairs(String[] nums, String target) {
        int count = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for (String num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (String num : nums) {
            String suffix = target.substring(num.length());
            if (target.startsWith(num) && map.containsKey(suffix)) {
                count += map.get(suffix);
                if (suffix.equals(num)) {
                    count--;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        leetCode2023 solution = new leetCode2023();
        String[] nums = {"1", "1", "1"};
        String target = "11";
        int result = solution.numOfPairs(nums, target);
        System.out.println("Number of pairs: " + result); // Output: 6
    }
}
