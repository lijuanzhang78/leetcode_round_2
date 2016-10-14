package Passed;

public class PartitionEqualSubsetSum {
	public boolean canPartition(int[] a) {
        int sum = 0;
        for(int n:a){
            sum += n;
        }
        if(sum%2>0)
            return false;
            
        boolean []dp = new boolean[sum/2+1];
        dp[0]=true; // empty array
        int max=0;
        for(int i: a){
            if(i>sum/2) return false;  // single number making bigger than sum/2 no way equal partition.
            for(int j = sum/2; j >= i; j--){ 
                if (dp[j-i]) dp[j] = true;
            }
        }
        return dp[sum/2];        
    }
	}
