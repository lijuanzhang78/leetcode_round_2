package BFS;

public class CourseScheduleII_BFS {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            if (numCourses == 0) {
                return new int[numCourses];
            } else {
                int[] topo = new int[numCourses];
                for(int i = 0; i < numCourses; i++) {
                    topo[i] = i;
                }
                return topo;
            }
        }
        
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
            indegrees[pre[0]]++;
        }
        
        int[] res = new int[numCourses];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int curr = q.poll();
            res[count] = curr;
            count++;
            for(int adj : adjList.get(curr)) {
                indegrees[adj]--;
                if (indegrees[adj] == 0) q.add(adj);
            }
        }
        if (count != numCourses) return new int[0];
        return res;
    }
}
