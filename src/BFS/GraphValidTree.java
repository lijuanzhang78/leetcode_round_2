package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 可以BFS，DFS，UF

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) {
            if (n == 1) return true;
            return false;
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(0);
        visited[0] = 1;
        
        while(!q.isEmpty()) {
            Integer curr = q.poll();
            visited[curr] = 2;
            for(Integer adj : adjList.get(curr)) {
                if (visited[adj] == 0) {
                    q.offer(adj);
                    visited[adj] = 1;
                } else if (visited[adj] == 1) return false; // 必须是else if啊
            }
        }
        
        for(int status : visited) {
            if (status == 0) return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		int n = 5;
		int[][] edges = {{0,1}, {0,2}, {2,3}, {2,4}};
		boolean res = new GraphValidTree().validTree(n, edges);	
	}
}
