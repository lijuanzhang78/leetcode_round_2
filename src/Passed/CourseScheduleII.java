package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for(int i = 0; i < numCourses; i++) {
                res[i] = i;
            }
            return res;
        }
        
        List<List<Integer>> adjlist = new ArrayList<List<Integer>>();
        for(int i = 0; i < numCourses; i++) {
            adjlist.add(new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites) {
            adjlist.get(edge[1]).add(edge[0]);
        }
        
        int[] visited = new int[numCourses];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (!dfs(visited, adjlist,i, queue)) return new int[0];
            }
        }
        
        for(int i = 0; i < queue.size(); i++) {
            res[i] = queue.get(i);
        }

        return res;
    }
    
    boolean dfs(int[] visited, List<List<Integer>> adjlist, int source, LinkedList<Integer> queue) {
        visited[source] = 1;
        for(Integer w : adjlist.get(source)) {
            if (visited[w] == 1) return false;
            if (visited[w] == 0) {
                if(!dfs(visited, adjlist, w, queue)) return false;
            }
        }
        visited[source] = 2;
        queue.addFirst(source);
        return true;
    }
}
