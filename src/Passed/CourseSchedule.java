package Passed;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CourseSchedule {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<Integer, LinkedList<Integer>>();
        if (prerequisites == null) return true;
        buildAdjen(map, prerequisites);
        
        int[] visited = new int[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if(!dfs(map, visited,i)) return false;
            }
        }
        return true;
    }
    
    boolean dfs(Map<Integer, LinkedList<Integer>> map, int[] visited, int cur) {
        if(visited[cur] == 0) visited[cur] = -1;
        
        if (map.get(cur) != null) {
            for (int adj : map.get(cur)) {
                if (visited[adj] == -1) return false;
                else {
                    if (visited[adj] == 0) {
                        if (!dfs(map, visited, adj)) return false;
                    }
                }
            }
        }
        visited[cur] = 1;
        return true;
    }
    
    void buildAdjen(Map<Integer, LinkedList<Integer>> map,int[][] prerequisites) {
        for(int[] pre : prerequisites) {
            int course = pre[0];
            int precourse = pre[1];
            
            if (map.containsKey(course)) {
                LinkedList<Integer> list = map.get(course);
                list.add(precourse);
            } else {
                LinkedList<Integer> list = new LinkedList<Integer>();
                list.add(precourse);
                map.put(course, list);
            }
        }
    }
	
}
