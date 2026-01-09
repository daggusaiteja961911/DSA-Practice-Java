package org.example.Graph;

import java.util.*;

// BFS in GFG format 
public class BFS5 {

	public ArrayList<Integer> bfs(int V, ArrayList<ArrayList<Integer>> adj) {
		// BFS implementation 
		boolean visited[] = new boolean[V];
		ArrayList<Integer> bfsOrder = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		
		q.add(0);
		visited[0] = true;
		
		// Traverse the graph
		while(!q.isEmpty()) {
			int node = q.poll();
			bfsOrder.add(node);
			
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
		BFS5 bfs = new BFS5();
		int V = 5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(0).add(2);
		adj.get(1).add(0);
		adj.get(1).add(3);
		adj.get(2).add(0);
		adj.get(2).add(4);
		adj.get(3).add(1);
		adj.get(4).add(2);
		
		ArrayList<Integer> result = bfs.bfs(V, adj);
		System.out.println("BFS Order: " + result);
	}
}
