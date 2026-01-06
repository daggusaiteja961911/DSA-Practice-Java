package org.example.Graph;

import java.util.*;

public class GraphRepresentation {

	int V; // Number of vertices
	List<List<Integer>> adj; // Adjacency list representation
	
	public GraphRepresentation(int V) {
		this.V = V;
		adj = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int u, int v) {
		adj.get(u).add(v);
		adj.get(v).add(u); // For undirected graph & remove this line for directed graph
	}
}
