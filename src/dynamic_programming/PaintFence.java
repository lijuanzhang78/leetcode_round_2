package dynamic_programming;

public class PaintFence {
	public int numWays(int n, int k) {
	    if(n == 0) return 0;
	    else if(n == 1) return k;
	    int diffColorCounts = k*(k-1);
	    int sameColorCounts = k;
	    for(int i=2; i<n; i++) {
	        int temp = diffColorCounts;
	        diffColorCounts = (diffColorCounts + sameColorCounts) * (k-1);
	        sameColorCounts = temp;
	    }
	    return diffColorCounts + sameColorCounts;
	}

//  跟house robber是一类的题。每一步都需要记录多种状态，因为每种状态对后面的决策会有影响。
//	https://discuss.leetcode.com/topic/23426/o-n-time-java-solution-o-1-space
}
