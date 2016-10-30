package BFS;

public class CourseScheduleII_DFS {
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
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for(int[] pre : prerequisites) {
            adjList.get(pre[1]).add(pre[0]);
        }
        
        int[] visited = new int[numCourses];
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;
                if(!dfs(i,adjList,visited,res)) return new int[0];
            }
        }
        int[] topo = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            topo[i] = res.get(i);
        }
        return topo;
    }
    
    boolean dfs(int curr, List<List<Integer>> adjList, int[] visited, List<Integer> res) {
        for(int adj : adjList.get(curr)) {
            if (visited[adj] == 1) return false;
            if (visited[adj] == 0) {
                visited[adj] = 1;
                if (!dfs(adj,adjList,visited,res)) return false;
            }
        }
        visited[curr] = 2;
        res.add(0,curr);
        return true;
    }
}
