package Passed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {
	   public boolean validTree(int n, int[][] edges) {
	        if (edges == null || edges.length == 0) {
	            if (n == 1) return true;
	            return false;
	        }
	        List<Set<Integer>> adjlist = new ArrayList<Set<Integer>>();
	        for(int i = 0; i < n; i++) {
	            Set<Integer> list = new HashSet<>();
	            adjlist.add(list);
	        }
	        for(int[] edge : edges) {
	            int v0 = edge[0];
	            int v1 = edge[1];
	            adjlist.get(v0).add(v1);
	            adjlist.get(v1).add(v0);
	        }
	        boolean[] visited = new boolean[n];
	        if (!dfs(adjlist, 0, visited)) return false;
	        
	        for(int i = 0; i < n; i++) {
	            if(!visited[i]) return false;
	        }
	        return true;
	    }
	    
	    
	    public boolean dfs(List<Set<Integer>> adjlist, int source, boolean[] visited) {
	        visited[source] = true;
	        Set<Integer> adj = adjlist.get(source);
	        for(Integer w : adj) {
	            if (!visited[w]) {
	                adjlist.get(w).remove(source);
	                if(!dfs(adjlist, w, visited)) return false;
	            } else {
	                return false;
	                }
	            }
	        return true;
	    }	   
}
