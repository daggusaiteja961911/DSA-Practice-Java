package org.example.Graph;

// leetcode 997. Find the Town Judge
// In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.
// If the town judge exists, then:
// The town judge trusts nobody.

public class FindTheTownEdge2 {

	public int findJudge(int n, int trust[][]) {
		if(n == 1) return 1;
		
		int count[] = new int[n + 1];
		
		for(int t[] : trust) {
			count[t[0]]--; // Person who trusts someone
			count[t[1]]++; // Person who is trusted
		}
		
		for(int i = 1; i <= n; i++) {
			if(count[i] == n - 1) {
				return i;
			}
		}
		
		return -1;
	}
	
	public static void main(String args[]) {
		FindTheTownEdge2 obj = new FindTheTownEdge2();
		int trust[][] = {{1,2}};
		int n = 2;
		System.out.println(obj.findJudge(n, trust));
	}
}
