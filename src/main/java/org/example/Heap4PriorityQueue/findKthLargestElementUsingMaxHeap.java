package org.example.Heap4PriorityQueue;

import java.util.PriorityQueue;

public class findKthLargestElementUsingMaxHeap {
    public int findKthLargest(int[] nums, int k) {
        // Step 1: Create a max-heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Step 2: Add all numbers
        for (int num : nums) {
            maxHeap.add(num);
        }

        // Step 3: Remove k-1 largest elements
        for (int i = 0; i < k - 1; i++) {
            maxHeap.poll();
        }

        // Step 4: The next element is the kth largest
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        findKthLargestElementUsingMaxHeap sol = new findKthLargestElementUsingMaxHeap();
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Kth largest element: " + sol.findKthLargest(nums, k));
    }
}
