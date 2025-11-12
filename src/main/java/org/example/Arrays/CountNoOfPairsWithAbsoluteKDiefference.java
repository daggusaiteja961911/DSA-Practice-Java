package org.example.Arrays;

import java.util.HashMap;

public class CountNoOfPairsWithAbsoluteKDiefference {
    //LeetCode 2006. Count Number of Pairs With Absolute Difference K
    public int countKDifference(int[] nums, int k) {
            int count = 0;
            HashMap<Integer, Integer> hm = new HashMap <>();
            for(int num: nums){
                hm.put(num, hm.getOrDefault(num, 0)+1);
            }
            for(int num: nums){
                if(hm.containsKey(num-k)){
                    count+=hm.get(num-k);
                }
                if(hm.containsKey(num+k)){
                    count+=hm.get(num+k);
                }
            }
            return count/2;
        }

    public static void main(String[] args) {
        CountNoOfPairsWithAbsoluteKDiefference obj = new CountNoOfPairsWithAbsoluteKDiefference();
        int[] nums = {1, 2, 2, 1};
        int k = 1;
        System.out.println(obj.countKDifference(nums, k)); // Output: 4
    }
}
