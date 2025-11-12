package org.example.Arrays;

import java.util.HashSet;
import java.util.List;

public class SubArraysDistinctElementsSumOfSquareI {
    //Leetcode 2913
    public int sumCounts(List<Integer> nums) {
        int n =nums.size();
        int res = 0;
        for(int i =0;i<n;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<n;j++){
                int a=nums.get(j);
                set.add(a);
                int size = set.size();
                res+=size*size;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SubArraysDistinctElementsSumOfSquareI solution = new SubArraysDistinctElementsSumOfSquareI();
        List<Integer> nums = List.of(1,2,1);
        int result = solution.sumCounts(nums);
        System.out.println("Sum of squares of distinct elements in all subarrays: " + result);
    }
}
