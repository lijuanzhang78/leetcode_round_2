package Passed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        if (n == 0 || k == 0 || k > n) return new LinkedList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        helper(res,temp,n,k,1, visited);
        return res;
    }
    
    void helper(List<List<Integer>> res, List<Integer> temp, int n, int k, int start, boolean[] visited) {
        if (start > n && temp.size() < k) {
            return;
        }
        if (temp.size() == k)  { 
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = start; i <= n; i++) {
            if(visited[i-1]) continue;
            temp.add(i);
            //visited[i-1] = true;
            helper(res,temp,n,k,i+1,visited);
            temp.remove(temp.size()-1);
            //visited[i-1] = false;
        }
    }
    
    public static void main(String[] args) {
    	List<List<Integer>> res = new Combinations().combine(4, 2);
    }

}
