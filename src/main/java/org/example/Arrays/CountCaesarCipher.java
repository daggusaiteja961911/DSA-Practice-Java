package org.example.Arrays;

import java.util.HashMap;
import java.util.Map;

// LeetCode Problem 3805: Count Caesar Cipher Pairs

public class CountCaesarCipher {

	public long countPairs(String[] words) {

		Map<String, Integer> countMap = new HashMap<>();
        long pairs = 0;

        for (String word : words) {
            char arr[] = word.toCharArray();
            int first = arr[0];

            for (int i = 0; i < arr.length; i++) {
                arr[i] = (char) ((arr[i] - first + 26) % 26);
            }

            String pattern = new String(arr);

            if (countMap.containsKey(pattern)) {
                int oldCount = countMap.get(pattern);

                // all previous words with this pattern form pairs with current word
                pairs = pairs + oldCount;

                // increase count
                countMap.put(pattern, oldCount + 1);
            } else {
                // first time seeing this pattern
                countMap.put(pattern, 1);
            }
        }
        return pairs;
    }

    // main method for local testing
    public static void main(String[] args) {

    	CountCaesarCipher CountCaesarCipher = new CountCaesarCipher();

        String[] words = {"fusion", "layout"};
        System.out.println(CountCaesarCipher.countPairs(words)); // Output: 1
    }
}
