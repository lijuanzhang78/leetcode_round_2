package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            adjList.get(pre[1]).add(pre[0]);
        }
        
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if(!dfs(i,visited,adjList)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(int curr, int[] visited, List<List<Integer>> adjList) {
        for(int adj : adjList.get(curr)) {
            if (visited[adj] == 1) return false;
            visited[adj] = 1;
            if (!dfs(adj,visited,adjList)) return false;
        }
        visited[curr] = 2;
        return true;
    }
	
	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = new int[][]{{0,1}, {1,0}};
		boolean res = new CourseSchedule().canFinish(numCourses, prerequisites);		
	}
}
