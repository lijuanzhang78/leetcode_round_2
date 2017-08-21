package Backtracking;

public class BeautifulArrangement {
	int count = 0;
    public int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        helper(visited,0,N);
        return count;   
    }
    
    void helper(boolean[] visited, int pos, int N) {
        if (pos == N) {
            count++;
            return;
        }
        
        for(int i = 1; i <= N; i++) {
            if (visited[i-1]) continue;
            if ( (pos+1)%i != 0 && i%(pos+1) != 0) continue;
            visited[i-1] = true;
            helper(visited,pos+1,N);
            visited[i-1] = false;            
        }        
    }
}
