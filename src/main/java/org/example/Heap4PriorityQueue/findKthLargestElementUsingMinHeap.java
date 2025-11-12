package org.example.Heap4PriorityQueue;

import java.util.PriorityQueue;

public class findKthLargestElementUsingMinHeap {
    public static int findKthLargest(int[] nums, int k) {
        // Step 1: Create a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Step 2: Add elements
        for (int num : nums) {
            minHeap.add(num);

            // Step 3: Keep only top k elements
            if (minHeap.size() > k) {
                minHeap.poll(); // remove smallest
            }
        }

        // Step 4: The top of heap is the kth largest
        return minHeap.peek();
    }

    // Test the code
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println("Kth largest element: " + findKthLargest(nums, k));
    }
}
