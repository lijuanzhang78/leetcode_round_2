package Passed;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GraphValidTree_BFS {
	public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            if (n == 1) return true;
            return false;
        }
        
        int[] visited = new int[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; ++i) { adjList.add(new ArrayList<Integer>()); }
        for (int[] edge: edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        Deque<Integer> q = new ArrayDeque<>();
        q.addLast(0); visited[0] = 1;  // vertex 0 is in the queue, being visited
        while (!q.isEmpty()) {
            Integer cur = q.removeFirst();
            for (Integer succ: adjList.get(cur)) {
                if (visited[succ] == 1) { return false; }  // loop detected
                if (visited[succ] == 0) { q.addLast(succ); visited[succ] = 1; }
            }
            visited[cur] = 2;  // visit completed
        }
        for (int v: visited) { if (v == 0) { return false; } }  // # of connected components is not 1
        return true;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1},{0,2},{2,3},{2,4}};
		new GraphValidTree_BFS().validTree(n, edges);	
	}
}
