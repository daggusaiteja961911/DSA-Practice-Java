package org.example.Heap4PriorityQueue;

import java.util.*;

class Athlete {
    int index;
    int score;

    Athlete(int index, int score) {
        this.index = index;
        this.score = score;
    }
}

public class leetCode506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        String[] result = new String[n];

        // Step 1: Create a max heap based on score
        PriorityQueue<Athlete> pq = new PriorityQueue<>(
                (a, b) -> b.score - a.score  // descending order by score
        );

        // Step 2: Add all athletes to the heap
        for (int i = 0; i < n; i++) {
            pq.add(new Athlete(i, score[i]));
        }

        // Step 3: Assign ranks
        int rank = 1;
        while (!pq.isEmpty()) {
            Athlete current = pq.poll(); // highest score comes first
            int idx = current.index;

            if (rank == 1) result[idx] = "Gold Medal";
            else if (rank == 2) result[idx] = "Silver Medal";
            else if (rank == 3) result[idx] = "Bronze Medal";
            else result[idx] = String.valueOf(rank);

            rank++;
        }

        return result;
    }

    // Step 4: Test it
    public static void main(String[] args) {
        leetCode506 sol = new leetCode506();
        int[] score = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(sol.findRelativeRanks(score)));
    }
}
