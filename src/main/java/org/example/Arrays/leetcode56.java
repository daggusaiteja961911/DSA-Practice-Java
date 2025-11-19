package org.example.Arrays;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start;
    int end;

    Interval(int s, int e) {
        this.start = s;
        this.end = e;
    }
}

class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Convert int[][] → List<Interval>
        List<Interval> list = new ArrayList<>();
        for (int[] arr : intervals) {
            list.add(new Interval(arr[0], arr[1]));
        }

        // Step 2: Sort by start
        list.sort((a, b) -> a.start - b.start);

        // Step 3: Merge using Interval class
        List<Interval> result = new ArrayList<>();
        result.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Interval last = result.get(result.size() - 1);
            Interval curr = list.get(i);

            if (curr.start <= last.end) {
                // Merge
                last.end = Math.max(last.end, curr.end);
            } else {
                result.add(curr);
            }
        }

        // Step 4: Convert List<Interval> → int[][]
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i).start;
            ans[i][1] = result.get(i).end;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = sol.merge(intervals);

        for (int[] interval : merged) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
