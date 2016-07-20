package Passed;

import java.util.ArrayList;
import java.util.List;

public class NumberOfComponentsInAnUndirectedGraph {
	   public int countComponents(int n, int[][] edges) {
	        if (edges == null || edges.length == 0) {
	            return n;
	        }
	            
	        List<List<Integer>> adjlist = new ArrayList<List<Integer>>();
	        for (int i = 0; i < n; i++) {
	            adjlist.add(new ArrayList<Integer>());
	        }
	        for(int[] edge : edges) {
	            int v0 = edge[0];
	            int v1 = edge[1];
	            adjlist.get(v0).add(v1);
	            adjlist.get(v1).add(v0);
	        }
	        
	        boolean[] visited = new boolean[n];
	        int count = 0;
	        for(int i = 0; i < n; i++) {
	            if (!visited[i]) {
	                count++;
	                dfs(visited, adjlist, i);
	            }
	        }
	        
	        return count;
	    }
	    
	    void dfs(boolean[] visited, List<List<Integer>> adjlist, int source) {
	        visited[source] = true;
	        
	        for(Integer w : adjlist.get(source)) {
	            if (!visited[w]) {
	                dfs(visited, adjlist, w);
	            }
	        }
	    }
	   
	    public static void main(String[] args) {
	    	int n = 5;
	    	int[][] edges = {{0,1},{1,2},{3,4}};
	    	
	    	new NumberOfComponentsInAnUndirectedGraph().countComponents(n, edges);
	    }
}
