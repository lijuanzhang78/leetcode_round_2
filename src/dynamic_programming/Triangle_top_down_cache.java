package dynamic_programming;

import java.util.ArrayList;
import java.util.List;

public class Triangle_top_down_cache {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 0) return 0;
        long[][] cache = new long[triangle.size()][triangle.size()];
        for(int i = 0; i < cache.length; i++)
            for(int j = 0; j < cache.length; j++)
                cache[i][j] = Long.MIN_VALUE;
        dfs(triangle, 0, 0, cache);
        return (int)cache[0][0];
    }
    
    private int dfs(List<List<Integer>> triangle, int iCur, int jCur, long[][] cache){
        int min = Integer.MAX_VALUE;
        if(cache[iCur][jCur] != Long.MIN_VALUE){
            return (int)cache[iCur][jCur];
        }
        else if(iCur == triangle.size() - 1){
            cache[iCur][jCur] = triangle.get(iCur).get(jCur);
            return (int)cache[iCur][jCur];
        } else{
            min = dfs(triangle, iCur + 1, jCur, cache);
            min = Math.min(min, dfs(triangle, iCur + 1, jCur + 1, cache));
            cache[iCur][jCur] = min + triangle.get(iCur).get(jCur);
            return (int)cache[iCur][jCur];
        }
    }
	   
    public static void main(String[] args) {
    	List<Integer> list1 = new ArrayList<>();
    	list1.add(-1);
    	
    	List<Integer> list2 = new ArrayList<>();
    	list2.add(3); list2.add(2);
    	
    	List<Integer> list3 = new ArrayList<>();
    	list3.add(-1); list3.add(-2); list3.add(-1);
    	
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
    	list.add(list1); list.add(list2); list.add(list3);
    	
    	
    	int res = new Triangle_top_down_cache().minimumTotal(list);	
    }

}
