package org.example.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// BFS in LeetCode format
public class BFS3 {

	public boolean bfs(int n, int edges[][], int start, int end) {
		// Create adjacency list
		List<List<Integer>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		// BFS implementation 
		boolean visited[] = new boolean[n];
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		
		// Traverse the graph
		while(!q.isEmpty()) {
			int node = q.poll();
			if(node == end) {
				return true;
			}
			
			for(int neighbor : adj.get(node)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					q.add(neighbor);
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]) {
		BFS3 bfs = new BFS3();
		int n = 6;
		int edges[][] = {{0,1},{0,2},{1,3},{2,4},{3,5}};
		int start = 0;
		int end = 5;
		boolean result = bfs.bfs(n, edges, start, end);
		System.out.println("Path exists from " + start + " to " + end + ": " + result);
	}
}
