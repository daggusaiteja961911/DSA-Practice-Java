package org.example.Heap4PriorityQueue;

import java.util.*;

public class SortCharacterByFrequency {
    public String frequencySort(String s) {
        // Step 1: Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max heap sorted by frequency
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        // Step 3: Add all entries to the heap
        maxHeap.addAll(freqMap.entrySet());

        // Step 4: Build the result string
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            char ch = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        SortCharacterByFrequency sol = new SortCharacterByFrequency();
        System.out.println(sol.frequencySort("tree")); // Output: eert
        System.out.println(sol.frequencySort("cccaaa")); // Output: cccaaa or aaaccc
        System.out.println(sol.frequencySort("Aabb")); // Output: bbAa or bbaA
    }
}
