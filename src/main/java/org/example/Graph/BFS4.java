package org.example.Graph;

import java.util.*;

// BFS in LeetCode format , return type ArrayList of Integer 
public class BFS4 {
	
	public ArrayList<Integer> bfs (int n, int edges[][], int start, int end){
		// Create adjacency list
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		for(int i=0;i<edges.length;i++) {
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		
		// BFS implementation 
		boolean visited[] = new boolean[n];
		ArrayList<Integer> bfsOrder = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		q.add(start);
		visited[start] = true;
		
		// Traverse the graph
		while(!q.isEmpty()) {
			int node = q.poll();
			bfsOrder.add(node);
			if(node == end) {
				return bfsOrder;
			}
			
			for(int neighbor : adj.get(node)) {
				if(!visited[neighbor]) {
					visited[neighbor] = true;
					q.add(neighbor);
				}
			}
		}
		return bfsOrder;
	}
	
	public static void main(String args[]) {
		BFS4 bfs = new BFS4();
		int n = 6;
		int edges[][] = {{0,1},{0,2},{1,3},{2,4},{3,5}};
		int start = 0;
		int end = 5;
		ArrayList<Integer> result = bfs.bfs(n, edges, start, end);
		System.out.println("BFS Order from " + start + " to " + end + ": " + result);
	}

}
