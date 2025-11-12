package org.example.Arrays;

import java.util.*;

public class FindTheUserActiveMinutes {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        // Step 1: Map each user -> unique set of minutes
        Map<Integer, Set<Integer>> userMinutes = new HashMap<>();

        for (int[] log : logs) {
            int user = log[0];
            int minute = log[1];

            // If user not in map, add new set
            if (!userMinutes.containsKey(user)) {
                userMinutes.put(user, new HashSet<>());
            }

            // Add minute to this user's set
            userMinutes.get(user).add(minute);
        }

        // Step 2: Create result array
        int[] answer = new int[k];

        // Step 3: Count how many users had i active minutes
        for (Set<Integer> minutes : userMinutes.values()) {
            int activeCount = minutes.size(); // number of unique minutes
            if (activeCount <= k) {
                answer[activeCount - 1]++; // -1 because array is 0-indexed
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        FindTheUserActiveMinutes s = new FindTheUserActiveMinutes();

        int[][] logs = {
                {0,5},
                {1,2},
                {0,2},
                {0,5},
                {1,3}
        };
        int k = 5;

        int[] result = s.findingUsersActiveMinutes(logs, k);

        System.out.println(Arrays.toString(result)); // [0, 2, 0, 0, 0]
    }
}

