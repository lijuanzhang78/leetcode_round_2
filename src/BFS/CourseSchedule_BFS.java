package BFS;

// Topological Sort - BFS
public class CourseSchedule_BFS {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
        
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int[] pre = prerequisites[i];
            adjList.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }
        
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            count++;
            for(int adj : adjList.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }
        
        return count == numCourses;
    }
}
